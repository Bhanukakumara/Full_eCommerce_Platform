package edu.bks.full_ecommerce_platform.services.impl;

import edu.bks.full_ecommerce_platform.dtos.UserDto;
import edu.bks.full_ecommerce_platform.entities.User;
import edu.bks.full_ecommerce_platform.entities.UserPaymentMethod;
import edu.bks.full_ecommerce_platform.enums.AccountStatus;
import edu.bks.full_ecommerce_platform.enums.UserRole;
import edu.bks.full_ecommerce_platform.repositories.UserRepository;
import edu.bks.full_ecommerce_platform.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public UserDto getUserByEmail(String email) {
        return modelMapper.map(userRepository.findByEmail(email), UserDto.class);
    }

    @Override
    public UserDto getUserByPhoneNumber(String phoneNumber) {
        return modelMapper.map(userRepository.findByPhoneNumber(phoneNumber), UserDto.class);
    }

    @Override
    public User createUser(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()) != null){
            return userRepository.save(modelMapper.map(userDto, User.class));
        }
        else {
            return null;
        }
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDetails) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            return null;
        }
        else {
            User user1 = user.get();
            user1.setEmail(userDetails.getEmail());
            user1.setFirstName(userDetails.getFirstName());
            user1.setMiddleName(userDetails.getMiddleName());
            user1.setLastName(userDetails.getLastName());
            user1.setDisplayName(userDetails.getDisplayName());
            user1.setProfilePicture(userDetails.getProfilePicture());
            user1.setPhoneNumber(userDetails.getPhoneNumber());
            user1.setDateOfBirth(userDetails.getDateOfBirth());
            user1.setGender(userDetails.getGender());
            user1.setUpdatedBy(userDetails.getUpdatedBy());
            return modelMapper.map(userRepository.save(user1), UserDto.class);
        }
    }

    @Override
    public boolean updatePassword(Long userId, String currentPassword, String newPassword) {
        return false;
    }

    @Override
    public UserDto updateAccountStatus(Long userId, AccountStatus status, String updatedBy) {
        return null;
    }

    @Override
    public UserDto updateUserRole(Long userId, UserRole role, String updatedBy) {
        return null;
    }

    @Override
    public boolean softDeleteUser(Long userId, String deletedBy) {
        return false;
    }

    @Override
    public boolean hardDeleteUser(Long userId) {
        return false;
    }

    @Override
    public UserPaymentMethod addPaymentMethod(Long userId, UserPaymentMethod paymentMethod) {
        return null;
    }

    @Override
    public UserPaymentMethod updatePaymentMethod(Long userId, Long paymentMethodId, UserPaymentMethod paymentMethod) {
        return null;
    }

    @Override
    public boolean removePaymentMethod(Long userId, Long paymentMethodId) {
        return false;
    }

    @Override
    public List<UserPaymentMethod> getUserPaymentMethods(Long userId) {
        return List.of();
    }

    @Override
    public UserDto updateProfilePicture(Long userId, String profilePicture) {
        return null;
    }

    @Override
    public List<UserDto> getUsersByStatus(AccountStatus status) {
        return List.of();
    }

    @Override
    public List<UserDto> getUsersByRole(UserRole role) {
        return List.of();
    }

    @Override
    public List<UserDto> searchUsers(String keyword, AccountStatus status, UserRole role, LocalDate fromDate, LocalDate toDate) {
        return List.of();
    }

    @Override
    public long countUserRegistrations(LocalDate fromDate, LocalDate toDate) {
        return 0;
    }
}
