package com.group13.footballer.Models.dto;

import lombok.Data;

@Data
public class UpdateFootballTeamRequest {
    private Long id;

    private String footballTeamName;

    private int footballTeamCapacity;

    private int footballTeamCurrentCount;

}
