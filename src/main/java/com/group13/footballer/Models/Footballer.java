package com.group13.footballer.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

    @OneToOne(mappedBy = "footballer")
    private User user;

/*    @OneToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Footballer_Team_TABLE",
            joinColumns = {
                    @JoinColumn(name = "footballer_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "team_id", referencedColumnName = "id")
            }
    )
    private Set<FootballTeam> footballTeams;*/

/*    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "footballer_review",
            joinColumns = @JoinColumn(name = "review_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "footballer_id",
                    referencedColumnName = "id"))
    private List<Review> reviewList;*/
}
