package com.orcrist.user.service;

import com.orcrist.user.dto.UserDTO;
import com.orcrist.user.model.Role;
import com.orcrist.user.model.User;
import com.orcrist.user.repository.RoleRepository;
import com.orcrist.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = userRepository.save(convertToUser(userDTO));
        return convertToUserDTO(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(userDTO.getUsername());

            User updatedUser = userRepository.save(existingUser);
            return convertToUserDTO(updatedUser);
        }
        return null;
    }

    public void addUserRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);

        if (user != null && role != null) {
            user.getRoles().add(role);
            userRepository.save(user);
        }
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return convertToUserDTOList(users);
    }

    private User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        return user;
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    private List<UserDTO> convertToUserDTOList(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(convertToUserDTO(user));
        }
        return userDTOs;
    }
}
