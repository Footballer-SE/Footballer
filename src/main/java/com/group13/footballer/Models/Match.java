package com.group13.footballer.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @Column(name = "request_made_by")
    private String requestMadeBy;

    @Column(name = "_request")
    private String request;

    @Column(name = "_response")
    private String response;

    @Column(name ="is_succeed")
    private Boolean isSucceed;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn
    private FootballTeam footballTeam;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn
    private Advert advert;
}
