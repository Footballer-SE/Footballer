package com.group13.footballer.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class FootballTeam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String Name;
    @Column(nullable = false, updatable = true)
    private Date MatchDateTime;
    @Column(columnDefinition = "text[]")
    @Type(type = "com.group13.footballer.Config.GenericArrayUserType")
    private String[] emptySpots;
<<<<<<< HEAD
=======

    @OneToOne(mappedBy = "footballTeam")
    private Footballer footballer;

>>>>>>> parent of 215645b (something)
    /*@OneToMany(mappedBy = "footballTeam")
    private List<TeamMate> teamMateList;*/
}
