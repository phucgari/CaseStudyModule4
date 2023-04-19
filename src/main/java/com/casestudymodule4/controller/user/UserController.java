package com.casestudymodule4.controller.user;

import com.casestudymodule4.model.user.User;
import com.casestudymodule4.security.jwt.JwtProvider;
import com.casestudymodule4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        List<User> users = (List<User>) userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserInformation(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(userOptional.get().getId());
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @GetMapping("/view")
    public ResponseEntity<User> viewBook(@RequestHeader(name = "Authorization") String authorization) {
        User user = jwtProvider.getUserFromBearer(authorization).get();
        return ResponseEntity.ok(user);
    }
}