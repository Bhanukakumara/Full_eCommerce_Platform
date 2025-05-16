package edu.bks.full_ecommerce_platform.services;

import edu.bks.full_ecommerce_platform.dtos.UserDto;
import edu.bks.full_ecommerce_platform.entities.User;
import edu.bks.full_ecommerce_platform.entities.UserPaymentMethod;
import edu.bks.full_ecommerce_platform.enums.AccountStatus;
import edu.bks.full_ecommerce_platform.enums.UserRole;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto getUserByEmail(String email);
    UserDto getUserByPhoneNumber(String phoneNumber);
    User createUser(UserDto userDto);
    UserDto updateUser(Long userId, UserDto userDetails);
    boolean updatePassword(Long userId, String currentPassword, String newPassword);
    UserDto updateAccountStatus(Long userId, AccountStatus status, String updatedBy);
    UserDto updateUserRole(Long userId, UserRole role, String updatedBy);
    boolean softDeleteUser(Long userId, String deletedBy);
    boolean hardDeleteUser(Long userId);
    UserPaymentMethod addPaymentMethod(Long userId, UserPaymentMethod paymentMethod);
    UserPaymentMethod updatePaymentMethod(Long userId, Long paymentMethodId, UserPaymentMethod paymentMethod);
    boolean removePaymentMethod(Long userId, Long paymentMethodId);
    List<UserPaymentMethod> getUserPaymentMethods(Long userId);
    UserDto updateProfilePicture(Long userId, String profilePicture);
    List<UserDto> getUsersByStatus(AccountStatus status);
    List<UserDto> getUsersByRole(UserRole role);
    List<UserDto> searchUsers(String keyword, AccountStatus status, UserRole role, LocalDate fromDate, LocalDate toDate);
    long countUserRegistrations(LocalDate fromDate, LocalDate toDate);
}
