package com.casestudymodule4.controller;

import com.casestudymodule4.model.DTO.request.SignInForm;
import com.casestudymodule4.model.DTO.request.SignUpForm;
import com.casestudymodule4.model.DTO.response.JwtResponse;
import com.casestudymodule4.model.DTO.response.ResponseMessage;
import com.casestudymodule4.model.user.Role;
import com.casestudymodule4.model.user.User;
import com.casestudymodule4.security.jwt.JwtProvider;
import com.casestudymodule4.security.principle.UserPrinciple;
import com.casestudymodule4.service.role.IRoleService;
import com.casestudymodule4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("The username is existed"), HttpStatus.OK);
        }
        User user = new User(signUpForm.getAvatar(), signUpForm.getFullName(),
                            signUpForm.getUsername(), signUpForm.getPassword(),
                            signUpForm.getEmail(), signUpForm.getPhone(), signUpForm.getAddress());
        Set<String> stringRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        stringRoles.forEach(role -> {
            switch (role) {
                case "host": {
                    Role hostRole = roleService.findByName(Role.RoleType.HOST)
                            .orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(hostRole);
                    break;
                }
                case "user": {
                    Role userRole = roleService.findByName(Role.RoleType.USER)
                            .orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(userRole);
                    break;
                }
            }
        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new ResponseMessage("Create success!"), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Optional<User> user=userService.findByUsername(signInForm.getUsername());
        if(user.isEmpty())return new ResponseEntity<>("InvalidUser",HttpStatus.OK);
        if(!Objects.equals(user.get().getPassword(), signInForm.getPassword()))
            return new ResponseEntity<>("InvalidPassword",HttpStatus.OK);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getFullName(), userPrinciple.getAuthorities()));
    }
}
