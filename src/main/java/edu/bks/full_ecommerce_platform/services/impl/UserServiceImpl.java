package edu.bks.full_ecommerce_platform.services.impl;

import edu.bks.full_ecommerce_platform.dtos.UserDto;
import edu.bks.full_ecommerce_platform.repositories.UserRepository;
import edu.bks.full_ecommerce_platform.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        userRepository.findAll().forEach(user -> userDtoList.add(modelMapper.map(user, UserDto.class)));
        return userDtoList;
    }

    @Override
    public UserDto getUserById(Long id) {
        return modelMapper.map(userRepository.findById(id), UserDto.class);
    }
}
