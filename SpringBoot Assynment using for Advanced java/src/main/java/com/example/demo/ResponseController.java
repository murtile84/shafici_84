package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api") // optional base path
public class ResponseController {

    // GET /success returns 200 OK with custom header
    @GetMapping("/success")
    public ResponseEntity<String> successEndpoint() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "HelloWorld");

        return ResponseEntity.ok()
                .headers(headers)
                .body("Request processed successfully");
    }

    // GET /not-found returns 404 with error details
    @GetMapping("/not-found")
    public ResponseEntity<String> notFoundEndpoint() {
        String errorDetails = "{\"error\": \"Resource not found\", \"code\": 404}";

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorDetails);
    }

    // POST /create returns 201 CREATED with location header
    @PostMapping("/create")
    public ResponseEntity<String> createEndpoint(@RequestBody String data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/resources/"));

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body("Resource created");
    }
}
