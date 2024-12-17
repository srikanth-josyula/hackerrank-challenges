package com.example.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Enumeration;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    private static final String TARGET_URL = "http://localhost:8080";  // URL of the backend (Alfresco)
    private static final Logger logger = LoggerFactory.getLogger(ProxyController.class);

    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    private final ProxyService proxyService;

    // Constructor-based injection for RestTemplate
    public ProxyController(RestTemplate restTemplate, ProxyService proxyService) {
        this.restTemplate = restTemplate;
        this.proxyService = proxyService;
    }

    // Handles all HTTP requests including /render/{nodeId}
    @RequestMapping("/**")
    public void proxyRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestUri = request.getRequestURI();

        // Check if it's a request for /render/{nodeId}
        if (requestUri.startsWith("/render/")) {
            handleRenderNodeId(request, response);
        } else {
            // Regular proxy request
            handleProxyRequest(request, response);
        }
    }

    private void handleProxyRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Construct the target URL to forward the request
            String forwardUrl = TARGET_URL + request.getRequestURI();

            // Build the URI
            URI uri = UriComponentsBuilder.fromHttpUrl(forwardUrl)
                    .query(request.getQueryString())  // Include any query parameters
                    .build().toUri();

            // Forward the request
            ResponseEntity<byte[]> restResponse = proxyService.forwardRequest(uri, request, HttpMethod.resolve(request.getMethod()));

            // Process response (handling HTML content rewriting)
            processResponse(restResponse, response);
        } catch (Exception e) {
            logger.error("Error occurred while proxying request: {}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Internal Server Error");
        }
    }

    private void handleRenderNodeId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Extract and manipulate nodeId
            String nodeId = request.getRequestURI().substring("/render/".length());
            String manipulatedNodeId = proxyService.manipulateNodeId(nodeId);

            // Construct the target URL for the manipulated nodeId
            String forwardUrl = TARGET_URL + "/share/s/" + manipulatedNodeId;
            URI uri = URI.create(forwardUrl);

            // Forward the request
            ResponseEntity<byte[]> restResponse = proxyService.forwardRequest(uri, request, HttpMethod.GET);

            // Process and return the response
            processResponse(restResponse, response);
        } catch (Exception e) {
            logger.error("Error occurred while processing render request: {}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Internal Server Error");
        }
    }

    // Processes the response from the backend and handles content rewriting if necessary
    private void processResponse(ResponseEntity<byte[]> restResponse, HttpServletResponse response) throws IOException {
        if (restResponse.getHeaders().getContentType() != null &&
                restResponse.getHeaders().getContentType().includes(MediaType.TEXT_HTML)) {
            // Rewrite URLs for HTML responses
            String modifiedBody = new String(restResponse.getBody());
            modifiedBody = modifiedBody.replace("http://localhost:8888", "http://localhost:8080");

            // Set response headers and body
            response.setStatus(restResponse.getStatusCodeValue());
            restResponse.getHeaders().forEach((key, value) -> response.setHeader(key, value.get(0)));
            response.getOutputStream().write(modifiedBody.getBytes());
        } else {
            // Return the original response for non-HTML responses
            response.setStatus(restResponse.getStatusCodeValue());
            restResponse.getHeaders().forEach((key, value) -> response.setHeader(key, value.get(0)));
            response.getOutputStream().write(restResponse.getBody());
        }
        response.flushBuffer();
    }
}
