package com.ms29.event.registration.services;

import com.ms29.event.registration.constants.UserRoleConstant;
import com.ms29.event.registration.dto.UserRegistrationDto;
import com.ms29.event.registration.entities.User;
import com.ms29.event.registration.entities.UserRole;
import com.ms29.event.registration.repositories.UserRepository;
import com.ms29.event.registration.repositories.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(UserRegistrationDto registrationDto) {
        // Check if email already exists
        if (userRepository.existsByEmailAddress(registrationDto.getEmailAddress())) {
            throw new RuntimeException("Email address already registered");
        }

        // Get default user role
        UserRole userRole = userRoleRepository.findByUserRoleName(UserRoleConstant.DEFAULT_ROLE)
                .orElseThrow(() -> new RuntimeException("Default user role not found"));

        // Create new user
        User user = new User();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmailAddress(registrationDto.getEmailAddress());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setUserRole(userRole);

        return userRepository.save(user);
    }
}
