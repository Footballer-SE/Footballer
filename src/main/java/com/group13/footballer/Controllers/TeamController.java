package com.group13.footballer.Controllers;

import com.group13.footballer.Models.FootballTeam;
import com.group13.footballer.Models.dto.AdvertResponse;
import com.group13.footballer.Models.dto.CreateFootballTeamRequest;
import com.group13.footballer.Models.dto.FootballTeamResponse;
import com.group13.footballer.Models.dto.UpdateFootballTeamRequest;
import com.group13.footballer.Services.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {
    private final TeamService teamService;
    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @PostMapping("/addTeam")
    public ResponseEntity<Void> addTeam(@RequestBody CreateFootballTeamRequest createFootballTeamRequest){
        teamService.addTeam(createFootballTeamRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/team/{id}")
    public ResponseEntity<FootballTeamResponse> getTeamById(@PathVariable Long id){
        return new ResponseEntity<>(teamService.getTeamById(id),HttpStatus.OK);
    }
    @PutMapping("/updateTeam")
    public ResponseEntity<FootballTeamResponse> updateTeam(@RequestBody UpdateFootballTeamRequest request){
        return new ResponseEntity<>(teamService.updateTeam(request),HttpStatus.OK);
    }

    @DeleteMapping("/deleteTeam/{id}")
    public ResponseEntity<FootballTeam> deleteTeam(@PathVariable Long id){
        teamService.deleteTeamById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/allTeams")
    public ResponseEntity<List<FootballTeamResponse>> getAllTeams(){
        return new ResponseEntity<>(teamService.getAllTeams(),HttpStatus.OK);
    }
}