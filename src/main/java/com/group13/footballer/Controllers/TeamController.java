package com.group13.footballer.Controllers;

import com.group13.footballer.Models.FootballTeam;
import com.group13.footballer.Models.Footballer;
import com.group13.footballer.Repositories.FootballerRepository;
import com.group13.footballer.Repositories.TeamRepository;
import com.group13.footballer.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {
    private final TeamService teamService;
    @Autowired
    FootballerRepository footballerRepository;
    @Autowired
    TeamRepository teamRepository;
    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }
    @GetMapping("/allTeams")
    public ResponseEntity<List<FootballTeam>> getTeams(){
        List<FootballTeam> teams = teamService.findAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
    @PostMapping("/addTeam")
    public ResponseEntity<FootballTeam> addTeam(@RequestBody FootballTeam footballTeam){
        FootballTeam newTeam = teamService.addTeam(footballTeam);
        return new ResponseEntity<>(newTeam,HttpStatus.CREATED);
    }
    @GetMapping("/team/{id}")
    public ResponseEntity<FootballTeam> getTeamById(@PathVariable Long id){
        FootballTeam team = teamService.findTeamById(id);
        return new ResponseEntity<>(team,HttpStatus.OK);
    }
    @PutMapping("/updateTeam/{id}")
    public ResponseEntity<FootballTeam> updateTeam(@RequestBody FootballTeam footballTeam){
        FootballTeam updatedTeam = teamService.updateTeam(footballTeam);
        return new ResponseEntity<>(updatedTeam,HttpStatus.OK);
    }
    @DeleteMapping("/deleteTeam/{id}")
    public ResponseEntity<FootballTeam> deleteTeam(@PathVariable Long id){
        teamService.deleteTeamById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
   /* @PostMapping("/{teamId}/footballers/{footballerId}")
    FootballTeam addFootbalerToTeam(
            @PathVariable Long teamId,
            @PathVariable Long footfootballerId
    ){
        FootballTeam footballTeam = teamRepository.findFootballTeamById(teamId).get();
        Footballer footballer = footballerRepository.findFootballerById(footfootballerId).get();
        footballTeam..add(footballer);
        return teamRepository.save(footballTeam);
    }*/

}
