package com.group13.footballer.Services;

import org.springframework.stereotype.Service;

import com.group13.footballer.Constant.Constant;
import com.group13.footballer.Exceptions.UserNotFoundException;
import com.group13.footballer.Models.User;
import com.group13.footballer.Repositories.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    protected User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(Constant.USER_NOT_FOUND));
    }

}
