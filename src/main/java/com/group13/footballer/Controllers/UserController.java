package com.group13.footballer.Controllers;

import com.group13.footballer.Exceptions.ResourceNotFoundException;
import com.group13.footballer.Models.User;
import com.group13.footballer.Repositories.UserRepository;
import com.group13.footballer.Security.CurrentUser;
import com.group13.footballer.Security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://footballerfe.netlify.app , https://footballer-production-1ce5.up.railway.app")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
