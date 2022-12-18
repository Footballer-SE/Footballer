package com.group13.footballer.Services;

import com.group13.footballer.Exceptions.MatchNotFound;
import com.group13.footballer.Models.Matchx;
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

    public ResponseEntity<Matchx> addMatch(Matchx matchx) {
        matchx = matchRepository.save(matchx);
        return new ResponseEntity<>(matchx, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Matchx>> getAllMatches() {
        List<Matchx> matchxes = matchRepository.findAll();
        return new ResponseEntity<>(matchxes,HttpStatus.OK);
    }

    public ResponseEntity<Matchx> getMatchById(Long id) {
        Matchx matchx = matchRepository.findById(id).orElseThrow(() -> new MatchNotFound("Match by" + id + "this Id could not be found."));
        return new ResponseEntity<>(matchx,HttpStatus.OK);
    }

    public ResponseEntity<Matchx> updateMatchById(Matchx matchx, Long id) {

        /* güncellenecek */
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity deleteMatchById(Long id) {
        Optional<Matchx> match = matchRepository.findById(id);
        if(match.isPresent()) {
            matchRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
