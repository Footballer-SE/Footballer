package com.group13.footballer.Models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {

    private Long id;

    private String name;

    private String email;

    private String imageUrl;

    private Boolean emailVerified ;

    private String telephoneNumber;

    private UserMeFootballTeamResponse footballTeam;
}
