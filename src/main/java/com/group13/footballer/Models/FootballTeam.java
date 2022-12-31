package com.group13.footballer.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FootballTeam {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String footballTeamName;

    private int footballTeamCapacity;

    private int footballTeamCurrentCount;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn
    private User user;



    public FootballTeam(String footballTeamName,int footballTeamCapacity,int footballTeamCurrentCount,User user){
        this.footballTeamName = footballTeamName;
        this.footballTeamCapacity = footballTeamCapacity;
        this.footballTeamCurrentCount = footballTeamCurrentCount;
        this.user = user;
    }

}
