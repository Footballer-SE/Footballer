package com.group13.footballer.Models;

import javax.persistence.*;

import com.group13.footballer.core.security.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users",uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
    private FootballTeam footballTeam;

   


    

   
}
