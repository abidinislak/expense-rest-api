package com.example.demo.restcontroller;


import com.example.demo.dataUtils.UserModel;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @Autowired
    UserService userService;


    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user) {

        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);

    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);


    }


    @PutMapping("/users/{id}")

    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserModel model) {

        return new ResponseEntity<>(userService.update(id, model), HttpStatus.OK);
    }


    @DeleteMapping("/users/{id}")

    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
