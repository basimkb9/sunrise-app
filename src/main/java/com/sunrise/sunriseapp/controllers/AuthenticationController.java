package com.sunrise.sunriseapp.controllers;

import com.sunrise.sunriseapp.dto.AuthenticationRequest;
import com.sunrise.sunriseapp.dto.AuthenticationResponse;
import com.sunrise.sunriseapp.dto.UserDto;
import com.sunrise.sunriseapp.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Valid
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDto userDto){
        return ResponseEntity.ok(authenticationService.register(userDto));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authRequest));
    }
}
