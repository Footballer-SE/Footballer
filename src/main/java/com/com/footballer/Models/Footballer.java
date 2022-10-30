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
public class Footballer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String Name;
    @Column(nullable = false)
    private String Surname;
    @Column(nullable = false)
    private String Email;
    @Column(nullable = false)
    private String PhoneNumber;
    @Column(nullable = false)
    private String City;

    @ManyToOne
    @JoinColumn(name = "FootballTeam_id")
    private FootballTeam footballTeam;


}
