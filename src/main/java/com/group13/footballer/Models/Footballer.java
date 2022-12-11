package com.group13.footballer.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "football_team_id")
    private FootballTeam footballTeam;

//    @OneToOne(mappedBy = "footballer")
//    private User user;
//
////    @OneToOne
////    @JoinColumn(name = "footballerTeam_id")
////    private FootballTeam footballTeam;
//
//
//
//    @OneToOne
//    @JoinColumn(name = "advert_id")
//    private Advert advert;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "football_team_id")
//    private FootballTeam footballTeam;



//    @Nullable
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
//    @JoinTable(name = "footballer_football_teams",
//            joinColumns = @JoinColumn(name = "footballer_"),
//            inverseJoinColumns = @JoinColumn(name = "football_teams_id"))
//    private Set<FootballTeam> footballTeams = new LinkedHashSet<>();
//
//    public Set<FootballTeam> getFootballTeams() {
//        return footballTeams;
//    }
//
//    public void setFootballTeams(Set<FootballTeam> footballTeams) {
//        this.footballTeams = footballTeams;
//    }



/*    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "footballer_review",
            joinColumns = @JoinColumn(name = "review_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "footballer_id",
                    referencedColumnName = "id"))
    private List<Review> reviewList;*/
}

// Footballer id : 2 -- team id : 3
