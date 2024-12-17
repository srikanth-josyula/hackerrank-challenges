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

        // Handle the response body
        byte[] responseBody = restResponse.getBody();
        String modifiedBody = new String(responseBody);

        // If the response content is HTML, modify the URLs (replace localhost:8888 with localhost:8080)
        if (restResponse.getHeaders().getContentType() != null &&
                restResponse.getHeaders().getContentType().includes(MediaType.TEXT_HTML)) {
            modifiedBody = modifiedBody.replace("http://localhost:8888", "http://localhost:8080");
            responseBody = modifiedBody.getBytes();  // Set the modified body
        }

        // Set the response status and headers
        response.setStatus(restResponse.getStatusCodeValue());
        for (String headerName : restResponse.getHeaders().keySet()) {
            response.setHeader(headerName, restResponse.getHeaders().getFirst(headerName));
        }

        // Return the response body (modified or unmodified)
        response.getOutputStream().write(responseBody);
        response.flushBuffer();  // Ensure that all data is sent to the client
    }

    /**
     * Copies headers from the HttpServletRequest to HttpHeaders object.
     * @param request The incoming HttpServletRequest
     * @param headers The HttpHeaders object to copy the headers to
     */
    private void copyHeaders(HttpServletRequest request, HttpHeaders headers) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headerValues = request.getHeaders(headerName);
            while (headerValues.hasMoreElements()) {
                headers.add(headerName, headerValues.nextElement());
            }
        }
    }
}
