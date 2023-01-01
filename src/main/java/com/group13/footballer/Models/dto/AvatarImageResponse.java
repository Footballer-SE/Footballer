package com.group13.footballer.Models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvatarImageResponse {
    private Long id;

    private String url;
}
