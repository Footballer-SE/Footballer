package com.group13.footballer.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users",uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
  
    private String userName;
   
    private String email;

    private String imageUrl;
    
    private Boolean emailVerified = false;
    @JsonIgnore
    private String password;
  
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    private String telephoneNumber;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    private List<Advert> adverts;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    private List<FootballTeam> footballTeams;

   
}
