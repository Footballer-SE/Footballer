package com.group13.footballer.Models.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.group13.footballer.core.security.AuthProvider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCurrentUserResponse {
    private Long id;
  
    private String name;
   
    private String email;

    private String imageUrl;
    
    private Boolean emailVerified = false;

    private String password;
  
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    private String telephoneNumber;

    private UserMeFootballTeamResponse footballTeam;

}
