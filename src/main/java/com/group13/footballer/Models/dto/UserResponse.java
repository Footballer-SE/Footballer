package com.group13.footballer.Models.dto;

import com.group13.footballer.core.security.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long userId;

    private String userName;

    private String email;

    private String telephoneNumber;
}
