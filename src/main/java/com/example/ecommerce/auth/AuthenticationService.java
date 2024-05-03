package com.example.ecommerce.auth;

import com.example.ecommerce.configuration.JWTService;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.utils.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest registerRequest){

        User prueba=this.repository.findByUsername(registerRequest.getUsername());
        if(prueba!=null){
            throw new ApplicationException(
                    Errors.USERNAME_ALREADY_EXIST,
                    "The username "+registerRequest.getUsername()+" already exist, try with other username",
                    HttpStatus.BAD_REQUEST
            );
        }
        prueba=this.repository.findByEmail(registerRequest.getEmail()).isPresent()?this.repository.findByEmail(registerRequest.getEmail()).get():null;
        if(prueba!=null){
            throw new ApplicationException(
                    Errors.EMAIL_ALREADY_TAKEN,
                    "There is already an account with the email: "+registerRequest.getEmail(),
                    HttpStatus.BAD_REQUEST
            );
        }
        if(!UtilMethods.isValidEmail(registerRequest.getEmail())){
            throw new ApplicationException(
                    Errors.INVALID_EMAIL,
                    "The email: "+registerRequest.getEmail()+" is invalid",
                    HttpStatus.BAD_REQUEST
            );
        }
        if(!registerRequest.getPassword().equals(registerRequest.getPassword2())){
            throw new ApplicationException(
                    Errors.PASSWORD_DONT_MATCH,
                    "The passwords doesnt match",
                    HttpStatus.BAD_REQUEST
            );
        }

        User user=User.builder()
                .firstName(registerRequest.getFirstName())
                .middleName(registerRequest.getMiddleName())
                .secondName(registerRequest.getSecondName())
                .lastName(registerRequest.getLastName())
                .username(registerRequest.getUsername())
                .identification(IdentityType.valueOf(registerRequest.getIdentification()))
                .identificationNumber(registerRequest.getIdentificationNumber())
                .email(registerRequest.getEmail())
                .direction(registerRequest.getDirection())
                .phone(registerRequest.getPhone())
                .role(UserRol.USER)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .isActive(true)
                .build();
        User saved=this.repository.save(user);
        String token=this.jwtService.generateToken(saved);
        return AuthenticationResponse.builder()
                .user(saved)
                .token(token)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword())
        );
        var user =repository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .user(user)
                .token(jwtToken).build();

    }



}
