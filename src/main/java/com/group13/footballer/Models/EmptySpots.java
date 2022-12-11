package com.group13.footballer.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class EmptySpots implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long SpotId;
    @Column
    private boolean isFilled;
    @Column
    private Enum<FootballerPosition> FootballerPositionEnum;

//    @ManyToOne
//    @JoinColumn(name = "footballTeam_id")
//    private FootballTeam footballTeam;
}
