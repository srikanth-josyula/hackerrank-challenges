package com.example.proxy;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${proxy.target.url}")
    private String targetUrl;  // Target URL to forward requests to (e.g., http://localhost:8080)

    private final RestTemplate restTemplate = new RestTemplate();

    // This method catches all HTTP requests made to localhost:8888
    @RequestMapping("/**")
    public void proxyRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Extract the scheme (http/https), host (localhost), and port (8888) from the incoming request
        String scheme = request.getScheme();  // http or https
        String host = request.getServerName();  // e.g., localhost
        int port = request.getServerPort();  // e.g., 8888 (or default 80 for HTTP)

        // Construct the source base URL (e.g., http://localhost:8888)
        String sourceUrl = scheme + "://" + host + ":" + port;

        // Construct the target URL by appending the request URI to the base URL
        String forwardUrl = targetUrl + request.getRequestURI();

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

        // If the response content is HTML, modify the URLs (replace the dynamic source URL with the target URL)
        if (restResponse.getHeaders().getContentType() != null &&
                restResponse.getHeaders().getContentType().includes(MediaType.TEXT_HTML)) {
            modifiedBody = modifiedBody.replace(sourceUrl, targetUrl);
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

---------
    package com.example.proxy;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${proxy.target.url}")
    private String targetUrl;  // Target URL to forward requests to (e.g., http://localhost:8080)

    private final RestTemplate restTemplate = new RestTemplate();

    // This method only allows the user to access /render/{nodeId}
    @RequestMapping("/render/{nodeId}")
    public void proxyRequest(@PathVariable String nodeId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Dynamically construct the source URL (e.g., http://localhost:8888)
        String sourceUrl = buildSourceUrl(request);

        // Construct the target URL by appending the request URI to the base URL
        String forwardUrl = targetUrl + request.getRequestURI();

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

        // If the response content is HTML, modify the URLs (replace the dynamic source URL with the target URL)
        if (restResponse.getHeaders().getContentType() != null &&
                restResponse.getHeaders().getContentType().includes(MediaType.TEXT_HTML)) {
            modifiedBody = modifiedBody.replace(sourceUrl, targetUrl);
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

    // Catch-all method for any other route manipulations
    @RequestMapping("/**")
    public void handleInvalidRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Return a 404 or 403 error for any route other than /render/{nodeId}
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "This page does not exist or is not accessible.");
    }

    /**
     * Helper method to build the source URL from the incoming request
     * @param request The incoming HttpServletRequest
     * @return The dynamically constructed source URL (e.g., http://localhost:8888)
     */
    private String buildSourceUrl(HttpServletRequest request) {
        String scheme = request.getScheme();  // http or https
        String host = request.getServerName();  // e.g., localhost
        int port = request.getServerPort();  // e.g., 8888 (or default 80 for HTTP)

        // Handle default ports for HTTP and HTTPS (80 and 443, respectively)
        if (("http".equals(scheme) && port == 80) || ("https".equals(scheme) && port == 443)) {
            return scheme + "://" + host;
        }

        // If the port is not the default, include the port in the URL
        return scheme + "://" + host + ":" + port;
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

