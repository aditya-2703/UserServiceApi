package com.ideabazaar.user.userserviceapi.service;

import com.ideabazaar.user.userserviceapi.client.ProjectClient;
import com.ideabazaar.user.userserviceapi.dto.ProjectDTO;
import com.ideabazaar.user.userserviceapi.dto.UserDTO;
import com.ideabazaar.user.userserviceapi.exceptions.UserNotFoundException;
import com.ideabazaar.user.userserviceapi.mapper.UserMapper;
import com.ideabazaar.user.userserviceapi.model.User;
import com.ideabazaar.user.userserviceapi.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private ProjectClient projectClientimp;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.projectClientimp = ProjectClient.create();
    }

    //   C -> user
    public UserDTO saveUser(UserDTO userDTO){
        // dto -> user
        User user = UserMapper.INSTANCE.userDtoToUser(userDTO);
        User updateduser = userRepository.save(user);
        // user -> dto
        return UserMapper.INSTANCE.userToUserDto(updateduser);

    }

    //  R -> user
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(UserMapper.INSTANCE.userToUserDto(user));
        }
        return userDTOs;
    }

    @Transactional
    public UserDTO getUserById(long id){
        User user = userRepository.findById(id).orElse(null);
        UserDTO userdto = UserMapper.INSTANCE.userToUserDto(user);
        List<ProjectDTO> projectdetailslist = projectClientimp.getAllProjectsByUserId(id);
        if(userdto != null){
            userdto.setProjects_details(projectdetailslist);
        }
        return userdto;
    }




    // U - update
    public UserDTO updatetUserByEmail(UserDTO userDTO){
        // dto -> user
        User user = UserMapper.INSTANCE.userDtoToUser(userDTO);
        if(user!=null){
            User updateduser = userRepository.save(user);
            // user -> dto
            return UserMapper.INSTANCE.userToUserDto(updateduser);
        }else{
            return null;
        }
    }

    // D -> Delete user by ID
    public boolean deleteUserById(long id) throws UserNotFoundException {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            throw new UserNotFoundException(id);
        }
    }
}
