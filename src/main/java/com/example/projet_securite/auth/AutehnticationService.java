package com.example.projet_securite.auth;

import com.example.projet_securite.config.JwtService;
import com.example.projet_securite.user.Role;
import com.example.projet_securite.user.User;
import com.example.projet_securite.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutehnticationService {

    private final UserRepository repository ;
    private final PasswordEncoder passwordEncoder ;
    private final JwtService jwtService ;
    private final AuthenticationManager authenticationManager ;

    public AuthenticationRespponse register(RegisterRequest request) {
        var user = User.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .grade(request.getGrade())
                .posteDeTravail(request.getPosteDeTravail())
                .numeroTelephone(request.getNumeroTelephone())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationRespponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationRespponse authenticat(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user =repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtoken=jwtService.generateToken(user);

        return AuthenticationRespponse.builder()
                .token(jwtoken)
                .build();
    }
}
