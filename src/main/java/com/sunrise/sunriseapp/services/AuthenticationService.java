package com.sunrise.sunriseapp.services;

import com.sunrise.sunriseapp.config.JwtService;
import com.sunrise.sunriseapp.dto.AuthenticationRequest;
import com.sunrise.sunriseapp.dto.AuthenticationResponse;
import com.sunrise.sunriseapp.dto.UserDto;
import com.sunrise.sunriseapp.model.User;
import com.sunrise.sunriseapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public static final String USER = "USER";
    public static final String VENDOR = "VENDOR";
    public static final String ADMIN = "ADMIN";

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    @Autowired
    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authManager = authManager;
    }

    public AuthenticationResponse register(UserDto userDto) {

        User user = toModel(userDto);

        System.out.println(user.getPassword());

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authRequest) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }

        User user = userRepository.findByEmail(authRequest.getEmail()).get();

        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private User toModel(UserDto dto){
        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        return User.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .phone(dto.getPhone())
                .password(encodedPassword)
                .role(dto.getRole())
                .build();
    }

    private UserDto toDto(User model){
        return UserDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phone(model.getPhone())
                .password(model.getPassword())
                .email(model.getEmail())
                .role(model.getRole())
                .build();
    }
}
