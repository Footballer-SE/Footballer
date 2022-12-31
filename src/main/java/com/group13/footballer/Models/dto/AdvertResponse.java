package com.group13.footballer.Models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.group13.footballer.Models.AdvertType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertResponse {

    private Long advertId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd@HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;

    private String description;

    private Boolean isActive;

    private CityResponse city;

    private UserResponse user;

    private AdvertType advertType;

    private List<PositionResponse> positions;


}
