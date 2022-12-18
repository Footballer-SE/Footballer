package com.group13.footballer.Controllers;

import com.group13.footballer.Models.Matchx;
import com.group13.footballer.Services.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/addMatch")
    public ResponseEntity<Matchx> addMatch(@RequestBody Matchx matchx){
        return matchService.addMatch(matchx);
    }

    @GetMapping("/allMatches")
    public ResponseEntity<List<Matchx>> getAllMatches() {
        return matchService.getAllMatches();
    }
    @GetMapping("/getMatch/{id}")
    public ResponseEntity<Matchx> getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @PutMapping("/updateMatch/{id}")
    public ResponseEntity<Matchx> updateMatchById(@RequestBody Matchx matchx, @PathVariable Long id) {
        return matchService.updateMatchById(matchx,id);
    }

    @DeleteMapping("/deleteMatch/{id}")
    public ResponseEntity deleteMatchById(@PathVariable Long id){
        return matchService.deleteMatchById(id);
    }
}
