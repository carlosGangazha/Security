package com.zimsec.Security.userAuth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponseDto register(UserCreateRequestDto request) {
        try {
            var user = new User(
                    request.getFull_name(),
                    request.getId_number(),
                    request.getEmail(),
                    request.getPhone_number(),
                    passwordEncoder.encode(request.getPassword()));
            repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return new AuthenticationResponseDto(jwtToken);
        }
        catch (IllegalArgumentException ex){
            throw new IllegalArgumentException();
        }
    }

    public AuthenticationResponseDto authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponseDto(jwtToken);

    }
}
