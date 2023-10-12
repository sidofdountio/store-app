package com.sidof.security.api;

import com.sidof.model.Response;
import com.sidof.security.model.Appuser;
import com.sidof.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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


    @PutMapping("/edit")
    public ResponseEntity<Response> updateUser(@RequestBody Appuser userToUpdate) {

        Response response = Response.builder()
                .timeStamp(now())
                .data(of("update", userService.edit(userToUpdate)))
                .message("edit user")
                .status(CREATED)
                .statusCode(CREATED.value())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Response> defaultUsers() {
        List<Appuser> users = userService.getUsers();
        var response = Response.builder()
                .timeStamp(now())
                .status(OK)
                .statusCode(OK.value())
                .message("")
                .data(of("user", users))
                .build();
        return ResponseEntity.ok(response);
    }
}

