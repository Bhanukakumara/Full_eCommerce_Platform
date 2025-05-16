package edu.bks.full_ecommerce_platform.controllers;

import edu.bks.full_ecommerce_platform.dtos.UserDto;
import edu.bks.full_ecommerce_platform.entities.User;
import edu.bks.full_ecommerce_platform.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    final UserService userService;

    @GetMapping("get-all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> allUsers = userService.getAllUsers();
        if (allUsers.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allUsers);
        }
        else {
            return ResponseEntity.ok(allUsers);
        }
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto userById = userService.getUserById(id);
        if (userById == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userById);
        }
        else {
            return ResponseEntity.ok(userById);
        }
    }

    @GetMapping("/get-by-email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
        UserDto userByEmail = userService.getUserByEmail(email);
        if (userByEmail == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            return ResponseEntity.ok(userByEmail);
        }
    }

    @GetMapping("/get-by-phoneNumber/{phoneNumber}")
    public ResponseEntity<UserDto> getUserByPhoneNumber(@PathVariable String phoneNumber){
        UserDto userByPhoneNumber = userService.getUserByPhoneNumber(phoneNumber);
        if (userByPhoneNumber == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            return ResponseEntity.ok(userByPhoneNumber);
        }
    }

    @PutMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
        User user = userService.createUser(userDto);
        if (user == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
        else {
            return ResponseEntity.ok(user);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        UserDto user = userService.updateUser(id, userDto);
        if (user == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
        else {
            return ResponseEntity.ok(user);
        }
    }
}
