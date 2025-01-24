package com.ideabazaar.user.userserviceapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UserNotFoundException extends Exception {

    public UserNotFoundException(Long id){
        super("User is Not present in Database with id ="+id);
    }
}
