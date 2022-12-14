package com.group13.footballer.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
  
    private String userName;
   
    private String email;

    private String imageUrl;
    
    private Boolean emailVerified = false;
   
    private String password;
  
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    private String telephoneNumber;

    

   
}
