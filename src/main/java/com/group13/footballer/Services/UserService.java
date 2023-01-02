package com.group13.footballer.Services;

import com.group13.footballer.Models.FootballTeam;
import com.group13.footballer.Models.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.group13.footballer.core.Exceptions.Constant.Constant;
import com.group13.footballer.core.Exceptions.UserNotFoundException;
import com.group13.footballer.Models.User;
import com.group13.footballer.Repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;


    public GetUserResponse getById(Long id){
        User user = findById(id);

        return new GetUserResponse
                (
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getImageUrl(),
                        user.getEmailVerified(),
                        user.getTelephoneNumber(),
                        new UserMeFootballTeamResponse
                                (
                                        user.getFootballTeam().getId(),
                                        user.getFootballTeam().getFootballTeamName(),
                                        user.getFootballTeam().getFootballTeamCapacity(),
                                        user.getFootballTeam().getFootballTeamCurrentCount(),
                                        new AvatarImageResponse(user.getFootballTeam().getAvatarImage().getId(),user.getFootballTeam().getAvatarImage().getUrl())
                                )
                );
    }
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(Constant.USER_NOT_FOUND));
    }
    public UserResponse getUserById(Long id) {
        User user = findById(id);
        return new UserResponse
                (
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getTelephoneNumber()

                );
    }
    public GetCurrentUserResponse updateUser(UpdateUserRequest request) {
        User updateUser = findById(request.getId());
        updateUser.setTelephoneNumber(request.getTelephoneNumber());
        User user = userRepository.save(updateUser);
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
                                            user.getFootballTeam().getFootballTeamCurrentCount(),
                                            new AvatarImageResponse(user.getFootballTeam().getAvatarImage().getId(),user.getFootballTeam().getAvatarImage().getUrl())

                                    )
                    );
        }
    }

}
