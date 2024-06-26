package com.example.ecommerce.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody RegisterRequest authenticationRequest){
        return ResponseEntity.ok(this.authenticationService.register(authenticationRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        System.out.println("2");
        return ResponseEntity.ok(this.authenticationService.authenticate(authenticationRequest));
    }
}
