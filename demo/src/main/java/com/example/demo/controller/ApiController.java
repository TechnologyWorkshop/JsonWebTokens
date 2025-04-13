package com.example.demo.controller;

import com.example.demo.model.AuthRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private final JwtUtil jwtUtil;

    public ApiController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {

        if ("user".equals(request.getUsername()) && "pass".equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @GetMapping("/test")
    public String test() {
        return "Hallo!";
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validate(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        boolean isValid = jwtUtil.validateToken(token);
        return ResponseEntity.ok(isValid ? "Valid" : "Invalid");
    }

    @GetMapping("/data/list")
    public ResponseEntity<List<String>> getData() {
        return ResponseEntity.ok(List.of("Test item 1", "Test item 2", "Test item 3"));
    }
}