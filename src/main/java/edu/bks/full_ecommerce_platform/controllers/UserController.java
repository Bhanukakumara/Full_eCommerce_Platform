package edu.bks.full_ecommerce_platform.controllers;

import edu.bks.full_ecommerce_platform.dtos.UserDto;
import edu.bks.full_ecommerce_platform.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    final UserService userService;

    @GetMapping("get-all")
    List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get-by-id/{id}")
    UserDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
}
