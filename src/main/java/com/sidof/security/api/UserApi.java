package com.sidof.security.api;

import com.sidof.security.Appuser;
import com.sidof.security.Role;
import com.sidof.security.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * @Author sidof
 * @Since 10/3/23
 * @Version v1.0
 * @YouTube @sidof8065
 */
@RestController
@RequestMapping("api/v1/store/user")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;

    @PostMapping("/addRole")
    public ResponseEntity<Role>addRole(@RequestBody Role role){
        return new ResponseEntity<Role>(userService.saverole(role),CREATED);
    }
    @PostMapping("/addRoleToUser")
    public ResponseEntity<AddRoleToUser>addRoleToUser(AddRoleToUser request){
        userService.addRoleToUser(request.getRoleName(),request.getUserName());
        return new ResponseEntity<>(CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List<Appuser>>users(){
        return new ResponseEntity<List<Appuser>>(userService.getUsers(),OK);
    }
}

