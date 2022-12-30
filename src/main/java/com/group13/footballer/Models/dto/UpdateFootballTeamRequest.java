package com.group13.footballer.Models.dto;

import lombok.Data;

@Data
public class UpdateFootballTeamRequest {
    private Long footballTeamId;

    private String footballTeamName;

    private int footballTeamCapacity;

    private int footballTeamCurrentCount;

}
