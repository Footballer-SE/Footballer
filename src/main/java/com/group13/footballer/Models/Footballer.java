package com.group13.footballer.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "footballerTeam_id")
    private FootballTeam footballTeam;

    @OneToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;

/*    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "footballer_review",
            joinColumns = @JoinColumn(name = "review_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "footballer_id",
                    referencedColumnName = "id"))
    private List<Review> reviewList;*/
}
