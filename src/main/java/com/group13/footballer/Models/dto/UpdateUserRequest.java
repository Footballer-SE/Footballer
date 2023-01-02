package com.group13.footballer.Models.dto;

import com.group13.footballer.core.security.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
public class UpdateUserRequest {
    private Long id;

    private String telephoneNumber;
}
