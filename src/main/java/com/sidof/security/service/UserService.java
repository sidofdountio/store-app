package com.sidof.security.service;

import com.sidof.security.Appuser;
import com.sidof.security.Role;
import com.sidof.security.api.AddRoleToUser;
import com.sidof.security.auth.AuthenticationRequest;
import com.sidof.security.auth.AuthenticationResponse;
import com.sidof.security.auth.RegisterRequest;
import com.sidof.security.config.JwtService;
import com.sidof.security.repo.RoleRepo;
import com.sidof.security.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author sidof
 * @Since 10/2/23
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService implements AppUserImplement {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public Appuser save(Appuser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("saving new user");
        return userRepo.save(user);
    }

    @Override
    public List<Appuser> getUsers() {
        log.info("Fetching users ...");
        return userRepo.findAll();
    }

    @Override
    public Appuser getUser(int userId) {
        return null;
    }

    @Override
    public Role saverole(Role role) {
        log.info("saving new role ");
        return roleRepo.save(role);
    }

    @Override
    public List<Role> roles() {
        log.info("Fetching roles ...");
        return roleRepo.findAll();
    }

    @Override
    public AddRoleToUser addRoleToUser(String roleName, String username) {
        var appuser = userRepo.findByName(username);
        Role role = roleRepo.findByName(roleName);
        log.info("Adding roles to user.");
        appuser.getRoles().add(role);
        return AddRoleToUser.builder()
                .userName(username)
                .roleName(roleName).build();
    }

    //Register user.
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var userToSave = Appuser.builder()
                .name(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .enable(true)
                .build();
        log.info("Register new user ",userToSave);
        userRepo.save(userToSave);
//        Find user
        String token = jwtService.generateToken(userToSave);
        return AuthenticationResponse.builder().token(token).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("email or password not found."));
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();
    }
}
