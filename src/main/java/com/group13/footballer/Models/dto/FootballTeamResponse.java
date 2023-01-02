package com.group13.footballer.Models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballTeamResponse {

    private Long id;

    private String footballTeamName;

    private int footballTeamCapacity;

    private int footballTeamCurrentCount;

    private UserResponse user;

    private AvatarImageResponse avatarImageResponse;
}
