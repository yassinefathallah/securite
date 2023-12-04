package com.example.projet_securite.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AutehnticationService service ;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationRespponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticat")
    public ResponseEntity<AuthenticationRespponse> authenticat(@RequestBody AuthenticationRequest request)
    {
        return ResponseEntity.ok(service.authenticat(request));
    }
}
