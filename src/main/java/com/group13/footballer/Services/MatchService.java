package com.group13.footballer.Services;

import com.group13.footballer.core.Exceptions.MatchNotFound;
import com.group13.footballer.Models.Match;
import com.group13.footballer.Repositories.MatchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public ResponseEntity<Match> addMatch(Match match) {
        match = matchRepository.save(match);
        return new ResponseEntity<>(match, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> matches = matchRepository.findAll();
        return new ResponseEntity<>(matches,HttpStatus.OK);
    }

    public ResponseEntity<Match> getMatchById(Long id) {
        Match match = matchRepository.findById(id).orElseThrow(() -> new MatchNotFound("Match by" + id + "this Id could not be found."));
        return new ResponseEntity<>(match,HttpStatus.OK);
    }

    public ResponseEntity<Match> updateMatchById(Match match, Long id) {

        /* güncellenecek */
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity deleteMatchById(Long id) {
        Optional<Match> match = matchRepository.findById(id);
        if(match.isPresent()) {
            matchRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
