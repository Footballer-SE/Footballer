package com.group13.footballer.Controllers;

import com.group13.footballer.core.Exceptions.ResourceNotFoundException;
import com.group13.footballer.Models.User;
import com.group13.footballer.Models.dto.GetCurrentUserResponse;
import com.group13.footballer.Models.dto.UserMeFootballTeamResponse;
import com.group13.footballer.Models.dto.UserResponse;
import com.group13.footballer.Repositories.UserRepository;
import com.group13.footballer.core.security.CurrentUser;
import com.group13.footballer.core.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    @Autowired
    private UserRepository userRepository;

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
                                            user.getFootballTeam().getFootballTeamId(),
                                            user.getFootballTeam().getFootballTeamName(),
                                            user.getFootballTeam().getFootballTeamCapacity(),
                                            user.getFootballTeam().getFootballTeamCurrentCount()

                                    )
                    );

        }


    }
}
