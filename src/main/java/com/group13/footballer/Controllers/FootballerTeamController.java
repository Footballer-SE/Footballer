package com.group13.footballer.Controllers;

import com.group13.footballer.Models.FootballTeam;
import com.group13.footballer.Models.Footballer;
import com.group13.footballer.Repositories.FootballerRepository;
import com.group13.footballer.Repositories.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footballer/team")
public class FootballerTeamController {
    TeamRepository teamRepository;
    FootballerRepository footballerRepository;

    public FootballerTeamController(TeamRepository teamRepository, FootballerRepository footballerRepository) {
        this.teamRepository = teamRepository;
        this.footballerRepository = footballerRepository;
    }
    @PostMapping
    public Footballer saveFootballerWithTeam(@RequestBody Footballer footballer){
        return footballerRepository.save(footballer);
    }
    @GetMapping("/getAll")
    public List<Footballer> findALlFootballers(){
        return footballerRepository.findAll();
    }
}
