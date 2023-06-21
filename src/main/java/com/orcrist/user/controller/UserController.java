package com.orcrist.user.controller;

import com.orcrist.user.dto.UserDTO;
import com.orcrist.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
        UserDTO newUserDTO = userService.addUser(userDTO);
        String message = "Kullanıcı oluşturuldu: " + newUserDTO.getUsername();
        return ResponseEntity.ok(message);
    }

    @PostMapping("/users/{userId}/roles/{roleId}")
    public ResponseEntity<String> addUserRole(@PathVariable Long userId, @PathVariable Long roleId) {
        userService.addUserRole(userId, roleId);
        return ResponseEntity.ok("Kullanıcıya rol eklendi");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Kullanıcı silindi");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        UserDTO updatedUserDTO = userService.updateUser(userId, userDTO);
        return ResponseEntity.ok(updatedUserDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAllUsers();
        return ResponseEntity.ok(userDTOs);
    }
}