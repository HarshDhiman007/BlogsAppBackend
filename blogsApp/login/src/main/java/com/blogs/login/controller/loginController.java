package com.blogs.login.controller;

import com.blogs.login.model.loginModel;
import com.blogs.login.service.loginInterfaceService;
import com.blogs.login.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class loginController {
    @Autowired
    loginService service;
    @CrossOrigin(allowedHeaders = "*",origins = "http://localhost:4200")
    @GetMapping("/getAll")
    public ResponseEntity<?> getALlLogin()
    {
        return new ResponseEntity<>(service.searchLogin(), HttpStatus.OK);
    }
    @CrossOrigin(allowedHeaders = "*",origins = "http://localhost:4200")
    @PostMapping("/register")
    public ResponseEntity<?> getALlLogin(@RequestBody loginModel model)
    {
        return new ResponseEntity<>(service.addLogin(model), HttpStatus.OK);
    }
    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody loginModel model)
    {
        return new ResponseEntity(service.getToken(model), HttpStatus.OK);
    }
}
