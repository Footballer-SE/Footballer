package com.group13.footballer.Controllers;

import com.group13.footballer.Models.Match;
import com.group13.footballer.Models.dto.CreateMatchRequest;
import com.group13.footballer.Models.dto.CreateMatchResponse;
import com.group13.footballer.Services.MatchService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<CreateMatchResponse> addMatch(@RequestBody CreateMatchRequest request){
        return new ResponseEntity<>(matchService.addMatch(request), HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteMatch/{id}")
    public ResponseEntity<Void> deleteMatchById(@PathVariable Long id){
        matchService.deleteMatchById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
