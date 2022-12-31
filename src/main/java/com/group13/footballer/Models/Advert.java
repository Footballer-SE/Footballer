package com.group13.footballer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd@HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;

    private String description;

    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    private AdvertType advertType;
 
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn
    private City city;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @ManyToMany
    @JoinTable(
    joinColumns = @JoinColumn,
    inverseJoinColumns = @JoinColumn
    )
    private List<Position> positions;



    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "advert")
    private List<Match> match;

    public Advert(LocalDateTime dateTime, String description, Boolean isActive, City city,AdvertType advertType, User user,List<Position> positions) {
        this.dateTime = dateTime;
        this.description = description;
        this.isActive = isActive;
        this.city = city;
        this.user = user;
        this.positions = positions;
        this.advertType=advertType;
    }
}
