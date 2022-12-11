package com.group13.footballer.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Availability implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;
    @Column(nullable = false)
    private Date StartDate;
    @Column(nullable = false)
    private Date EndDate;

//    @ManyToOne
//    @JoinColumn(name = "advert_id")
//    private Advert advert;
}
