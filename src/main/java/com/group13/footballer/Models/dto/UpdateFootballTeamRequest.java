package com.group13.footballer.Models.dto;

import com.group13.footballer.Models.AvatarImage;
import lombok.Data;

@Data
public class UpdateFootballTeamRequest {
    private Long id;

    private String footballTeamName;

    private int footballTeamCapacity;

    private int footballTeamCurrentCount;

    private AvatarImage AvatarImage;

}
