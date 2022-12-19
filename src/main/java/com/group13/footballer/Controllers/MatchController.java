package com.group13.footballer.Controllers;

import com.group13.footballer.Models.Match;
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
    public ResponseEntity<Match> addMatch(@RequestBody Match match){
        return matchService.addMatch(match);
    }

    @GetMapping("/allMatches")
    public ResponseEntity<List<Match>> getAllMatches() {
        return matchService.getAllMatches();
    }
    @GetMapping("/getMatch/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @PutMapping("/updateMatch/{id}")
    public ResponseEntity<Match> updateMatchById(@RequestBody Match match, @PathVariable Long id) {
        return matchService.updateMatchById(match,id);
    }

    @DeleteMapping("/deleteMatch/{id}")
    public ResponseEntity deleteMatchById(@PathVariable Long id){
        return matchService.deleteMatchById(id);
    }
}
