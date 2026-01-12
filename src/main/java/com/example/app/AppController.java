package com.example.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    @Value("${app.version:1.0}")
    private String appVersion;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> hello() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hello from Kubernetes!");
        response.put("timestamp", LocalDateTime.now());
        response.put("version", appVersion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "healthy");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/readiness")
    public ResponseEntity<Map<String, Boolean>> readiness() {
        Map<String, Boolean> response = new HashMap<>();
        response.put("ready", true);
        return ResponseEntity.ok(response);
    }
}