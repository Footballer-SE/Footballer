package com.group13.footballer.Controllers;

import com.group13.footballer.Models.dto.*;
import com.group13.footballer.Services.UserService;
import com.group13.footballer.core.Exceptions.ResourceNotFoundException;
import com.group13.footballer.Models.User;
import com.group13.footballer.Repositories.UserRepository;
import com.group13.footballer.core.security.CurrentUser;
import com.group13.footballer.core.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final UserService uS;

    public UserController(UserService uS) {
        this.uS = uS;
    }

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public GetCurrentUserResponse getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {

        User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        if (user.getFootballTeam() == null) {
            return new GetCurrentUserResponse
                    (
                            user.getId(),
                            user.getName(),
                            user.getEmail(),
                            user.getImageUrl(),
                            user.getEmailVerified(),
                            user.getPassword(),
                            user.getProvider(),
                            user.getProviderId(),
                            user.getTelephoneNumber(),
                            null
                    );
        } else {
            return new GetCurrentUserResponse
                    (
                            user.getId(),
                            user.getName(),
                            user.getEmail(),
                            user.getImageUrl(),
                            user.getEmailVerified(),
                            user.getPassword(),
                            user.getProvider(),
                            user.getProviderId(),
                            user.getTelephoneNumber(),
                            new UserMeFootballTeamResponse
                                    (
                                            user.getFootballTeam().getId(),
                                            user.getFootballTeam().getFootballTeamName(),
                                            user.getFootballTeam().getFootballTeamCapacity(),
                                            user.getFootballTeam().getFootballTeamCurrentCount()

                                    )
                    );

        }


    }
    @PutMapping("/updateUser")
    public ResponseEntity<GetCurrentUserResponse> updateUser(@RequestBody UpdateUserRequest request){
        return new ResponseEntity<>(uS.updateUser(request), HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> findbyId(@PathVariable Long id){
        return new ResponseEntity<>(uS.getUserById(id), HttpStatus.OK);
    }
}
