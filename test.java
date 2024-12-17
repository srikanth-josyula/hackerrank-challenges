package com.example.proxy;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Enumeration;

@RestController
public class ProxyController {

    private static final String TARGET_URL = "http://localhost:8080";  // URL of the backend (Alfresco)

    private final RestTemplate restTemplate = new RestTemplate();

    // This method catches all HTTP requests made to localhost:8888
    @RequestMapping("/**")
    public void proxyRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Construct the target URL by appending the request URI to the base URL
        String forwardUrl = TARGET_URL + request.getRequestURI();

        // Build the URI to forward to
        URI uri = UriComponentsBuilder.fromHttpUrl(forwardUrl)
                .query(request.getQueryString())  // Include any query params
                .build().toUri();

        // Create an HTTP entity to forward the request with headers
        HttpHeaders headers = new HttpHeaders();
        copyHeaders(request, headers);  // Correctly copy all headers from the incoming request
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Forward the request using RestTemplate
        ResponseEntity<byte[]> restResponse = restTemplate.exchange(uri, HttpMethod.resolve(request.getMethod()), entity, byte[].class);

        // Check if the response is HTML or contains URLs that need rewriting
        if (restResponse.getHeaders().getContentType() != null &&
                restResponse.getHeaders().getContentType().includes(MediaType.TEXT_HTML)) {
            byte[] responseBody = restResponse.getBody();
            String modifiedBody = new String(responseBody);

            // Replace any references to localhost:8888 with localhost:8080
            modifiedBody = modifiedBody.replace("http://localhost:8888", "http://localhost:8080");

            // Set the response status and headers
            response.setStatus(restResponse.getStatusCodeValue());
            for (String headerName : restResponse.getHeaders().keySet()) {
                response.setHeader(headerName, restResponse.getHeaders().getFirst(headerName));
            }

            // Return the modified body
            response.getOutputStream().write(modifiedBody.getBytes());
        } else {
            // For non-HTML responses (like images, JS, CSS), send the original response body
            response.setStatus(restResponse.getStatusCodeValue());
            for (String headerName : restResponse.getHeaders().keySet()) {
                response.setHeader(headerName, restResponse.getHeaders().getFirst(headerName));
            }
            response.getOutputStream().write(restResponse.getBody());
        }

        response.flushBuffer();  // Ensure that all data is sent to the client
    }
