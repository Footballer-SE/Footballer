package com.group13.footballer.Models.dto;

import com.group13.footballer.Models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFootballTeamRequest {
    private Long id;

    private String footballTeamName;

    private int footballTeamCapacity;

    private int footballTeamCurrentCount;
}
