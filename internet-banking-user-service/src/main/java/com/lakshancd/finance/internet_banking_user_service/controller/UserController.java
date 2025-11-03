package com.lakshancd.finance.internet_banking_user_service.controller;

import com.lakshancd.finance.internet_banking_user_service.model.dto.User;
import com.lakshancd.finance.internet_banking_user_service.model.dto.UserUpdateRequest;
import com.lakshancd.finance.internet_banking_user_service.service.KeycloakUserService;
import com.lakshancd.finance.internet_banking_user_service.service.UserService;
import jakarta.ws.rs.POST;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/bank-user")
@RequiredArgsConstructor
public class UserController {
    private final KeycloakUserService keycloakUserService;
    private final UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity createUser(@RequestBody User request){
        log.info("Creating User with {}" ,request.toString());
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long userId , @RequestBody UserUpdateRequest request){
        log.info("Updating User with id: {}" ,request.toString());
        return ResponseEntity.ok(userService.updateUser(userId, request));
    }

    @GetMapping
    public ResponseEntity readUsers(Pageable pageable) {
        log.info("Reading all users from API");
        return ResponseEntity.ok(userService.readUsers(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity readUser(@PathVariable("id") Long id) {
        log.info("Reading user by id {}", id);
        return ResponseEntity.ok(userService.readUser(id));
    }
}
