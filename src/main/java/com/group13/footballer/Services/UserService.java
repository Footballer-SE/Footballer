package com.group13.footballer.Services;

import com.group13.footballer.Models.dto.GetUserResponse;
import com.group13.footballer.Models.dto.UserMeFootballTeamResponse;
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
                                        user.getFootballTeam().getFootballTeamId(),
                                        user.getFootballTeam().getFootballTeamName(),
                                        user.getFootballTeam().getFootballTeamCapacity(),
                                        user.getFootballTeam().getFootballTeamCurrentCount()
                                )
                );
    }
    protected User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(Constant.USER_NOT_FOUND));
    }

}
