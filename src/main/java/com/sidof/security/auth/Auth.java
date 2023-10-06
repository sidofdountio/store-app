package com.sidof.security.auth;

import com.sidof.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

/**
 * @Author sidof
 * @Since 10/4/23
 * @Version v1.0
 * @YouTube @sidof8065
 */
@RestController
@RequestMapping("api/v1/store/auth")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequiredArgsConstructor
public class Auth {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
//        userService.addRoleToUser("ROLE_USER",registerRequest.getUsername());
        AuthenticationResponse registered = userService.register(registerRequest);
        return new ResponseEntity<AuthenticationResponse>(registered, CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity< AuthenticationResponse > register(@RequestBody AuthenticationRequest authenticationRequest){
        return new ResponseEntity<AuthenticationResponse>(userService.authenticate(authenticationRequest),OK);
    }
}
