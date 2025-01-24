package com.ideabazaar.user.userserviceapi.controller;

import com.ideabazaar.user.userserviceapi.dto.UserDTO;
import com.ideabazaar.user.userserviceapi.exceptions.UserNotFoundException;
import com.ideabazaar.user.userserviceapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/register", produces = MediaType.APPLICATION_JSON_VALUE)
public class User{

    UserService userService;

    User(UserService userService) {
        this.userService = userService;
    }

    // Testing  http://localhost:/api/v1/register/auth
    @GetMapping("/testing")
    public String test(){
        return "Hello World";
    }


    // C - user
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO userdto = userService.saveUser(userDTO);
        return new ResponseEntity<>(userdto, HttpStatus.CREATED);
    }

    // R - all
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> usersdto = userService.getAllUsers();
        return new ResponseEntity<>(usersdto, HttpStatus.OK);
    }
    // R - single
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable Long id) throws UserNotFoundException {
        UserDTO userdto = userService.getUserById(id);
        if(userdto == null) {
            throw new UserNotFoundException(id); // Throw the exception
        }
        return new ResponseEntity<>(userdto, HttpStatus.OK);
    }

    // U - update
    @PutMapping("/user/")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) throws UserNotFoundException {
        UserDTO updateduserdto = userService.updatetUserByEmail(userDTO);
        if(updateduserdto == null) {
            throw new UserNotFoundException(userDTO.getId());
        }
        return new ResponseEntity<>(updateduserdto, HttpStatus.OK);
    }

    // D - Delete
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        boolean isDeleted = userService.deleteUserById(id);

        if (isDeleted) {
            return ResponseEntity.ok("User  with ID " + id + " has been deleted."); // 200 OK with message
        } else {
            throw new UserNotFoundException(id);
        }
    }






}
