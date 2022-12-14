package com.group13.footballer.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Advert  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long advertId;
  
    private Date dateTime;

    private String description;
 
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn
    private City city;

    @ManyToMany
    @JoinTable(
    joinColumns = @JoinColumn,
    inverseJoinColumns = @JoinColumn
    )
    private List<Position> positions;


}
