package com.sidof.security.auth;

import com.sidof.model.Response;
import com.sidof.security.api.AddRoleToUser;
import com.sidof.security.model.AuthenticationRequest;
import com.sidof.security.model.AuthenticationResponse;
import com.sidof.security.model.RegisterRequest;
import com.sidof.security.model.Role;
import com.sidof.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.*;
import static java.util.Map.of;
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
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) throws InterruptedException {
        AuthenticationResponse registered = userService.register(registerRequest);

        return new ResponseEntity<AuthenticationResponse>(registered, CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity< AuthenticationResponse > register(@RequestBody AuthenticationRequest authenticationRequest){
        return new ResponseEntity<AuthenticationResponse>(userService.authenticate(authenticationRequest),OK);
    }


    @GetMapping(path = "/isTokenValid/{token}")
    public ResponseEntity<Boolean> isTokenValid(@PathVariable("token") String token){
        return new ResponseEntity<Boolean>(userService.isTokenValid(token),OK);
    }
}
