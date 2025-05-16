package edu.bks.full_ecommerce_platform.services;

import edu.bks.full_ecommerce_platform.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
}
