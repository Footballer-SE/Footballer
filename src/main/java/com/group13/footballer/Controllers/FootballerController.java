package com.group13.footballer.Controllers;

import com.group13.footballer.Models.FootballTeam;
import com.group13.footballer.Models.Footballer;
import com.group13.footballer.Repositories.FootballerRepository;
import com.group13.footballer.Repositories.TeamRepository;
import com.group13.footballer.Services.FootballerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FootballerController {
    final FootballerService footballerService;

    final TeamController teamController;

    final TeamRepository teamRepository;

    final FootballerRepository footballerRepository;

    public FootballerController(FootballerService footballerService, TeamController teamController, TeamRepository teamRepository, FootballerRepository footballerRepository) {
        this.footballerService = footballerService;
        this.teamController = teamController;
        this.teamRepository = teamRepository;
        this.footballerRepository = footballerRepository;
    }


    @GetMapping("/allFootballers")
    public ResponseEntity<List<Footballer>> getFootballers(){
        List<Footballer> footballers = footballerService.findAllFootballers();
        return new ResponseEntity<>(footballers, HttpStatus.OK);
    }
    @PostMapping("/addFootballer")
    public ResponseEntity<Footballer> addFootballer(@RequestBody Footballer footballer){
        Footballer newFootballer = footballerService.addFootballer(footballer);
        return new ResponseEntity<>(newFootballer,HttpStatus.CREATED);
    }
    @GetMapping("/footballer/{id}")
    public ResponseEntity<Footballer> getFootballerById(@PathVariable Long id){
        Footballer footballer = footballerService.findFootballerById(id);
        return new ResponseEntity<>(footballer,HttpStatus.OK);
    }
    @PutMapping("/updateFootballer/{id}")
    public ResponseEntity<Footballer> updateFootballer(@PathVariable Long id,@RequestBody Footballer footballer){

        Footballer updatedFootballer = footballerService.updateFootballer(id,footballer);
        return new ResponseEntity<>(updatedFootballer,HttpStatus.OK);
    }
    @DeleteMapping("/deleteFootballer/{id}")
    public ResponseEntity<Footballer> deleteFootballer(@PathVariable Long id){
        footballerService.deleteFootballerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addFootballertoTeam/{footballer_id}/{team_id}")
    public void addFootballertoTeam(@PathVariable("footballer_id") Long id1, @PathVariable("team_id") Long id2){

        Optional<Footballer> footballer = footballerRepository.findById(id1);
        Optional<FootballTeam> team = teamRepository.findById(id2);
        if(footballer.isPresent() && team.isPresent()) {
            Footballer footballer1 = footballer.get();
            FootballTeam team1 = team.get();

            List<Footballer> footballers = (List<Footballer>) team1.getFootballers();
            footballers.add(footballer1);
            team1.setFootballers(footballers);
//            Set<FootballTeam> teams = footballer1.getFootballTeams();
//            teams.add(team1);
//            footballer1.setFootballTeams(teams);
            footballer1.setFootballTeam(team1);
            updateFootballer(id1,footballer1);
            teamController.updateTeam(id2,team1);
            System.out.println("İşlem tamam");
        }
    }

}
