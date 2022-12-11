package com.group13.footballer.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class TeamMate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long RequestMadeBy;

    @Column
    private Double Response;

    @Column
    private String Request;

//    @ManyToOne
//    @JoinColumn(name = "advert_id")
//    private Advert advert;
//
//    @ManyToOne
//    @JoinColumn(name = "footballTeam_id")
//    private FootballTeam footballTeam;
}
