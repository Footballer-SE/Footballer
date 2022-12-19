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

    private Long footballTeamId;
 
    private String footballTeamName;

    private int footballTeamCapacity;

    private int footballTeamCurrentCount;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "footballTeam")
    private List<Match> matches;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn
    private User user;
}
