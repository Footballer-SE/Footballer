package com.group13.footballer.Models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMatchResponse {

    private Long matchId;

    private UserResponse user;

    private AdvertResponse advert;
}
