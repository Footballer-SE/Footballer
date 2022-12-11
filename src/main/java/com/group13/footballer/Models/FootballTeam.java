package com.group13.footballer.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
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


    @OneToMany(mappedBy = "footballTeam", orphanRemoval = true,fetch = FetchType.EAGER)
    private Collection<Footballer> footballers = new ArrayList<>();

//    @Column(columnDefinition = "text[]")
//    @Type(type = "com.group13.footballer.Config.GenericArrayUserType")
//    private String[] emptySpots;

//    @JsonIgnore
//    @OneToMany(mappedBy = "footballTeam",fetch = FetchType.EAGER)
//    private List<Footballer> footballers = new LinkedList<>();



//    @ManyToMany(mappedBy = "footballTeams", cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
//    private Set<Footballer> footballers = new LinkedHashSet<>();
//
//    public Set<Footballer> getFootballers() {
//        return footballers;
//    }
//
//    public void setFootballers(Set<Footballer> footballers) {
//        this.footballers = footballers;
//    }



//    @OneToOne(mappedBy = "footballTeam")
//    private Footballer footballer;

    /*@OneToMany(mappedBy = "footballTeam")
    private List<TeamMate> teamMateList;*/
}
