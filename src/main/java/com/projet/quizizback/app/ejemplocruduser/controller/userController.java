package com.projet.quizizback.app.ejemplocruduser.controller;

import com.projet.quizizback.app.ejemplocruduser.entity.UserEntity;
import com.projet.quizizback.app.ejemplocruduser.services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class userController {
    private final UserServices userServices;

    public userController(UserServices userServices) {
        this.userServices = userServices;
    }

    /*@GetMapping
    public List<UserEntity> getUserServices() {
        return  userServices.getAll();
    }*/
    @GetMapping
    public List<UserEntity> getUserId(@RequestParam(required = false)  String ident) {
        return userServices.getById(ident);
    }

    @PostMapping
    public UserEntity postUser(@RequestBody UserEntity userEntity) {
        return userServices.saveUser(userEntity);
    }
}
