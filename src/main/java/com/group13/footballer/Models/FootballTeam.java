package com.group13.footballer.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @ManyToMany
    @JoinTable(
            name = "footballer_enrolled",
            joinColumns = @JoinColumn(name = "FootballTeam_id"),
            inverseJoinColumns = @JoinColumn(name = "Footballer_id")
    )
    public Set<Footballer> enrolledFootballer = new HashSet<>();





    /*@OneToMany(mappedBy = "footballTeam")
    private List<TeamMate> teamMateList;*/
}
