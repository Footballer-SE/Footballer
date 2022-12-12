package com.group13.footballer.Controllers;

import com.group13.footballer.Models.Footballer;
import com.group13.footballer.Services.FootballerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://footballerfe.netlify.app/ , https://footballer-production-1ce5.up.railway.app/")
public class FootballerController {
    private final FootballerService footballerService;

    public FootballerController(FootballerService footballerService){
        this.footballerService=footballerService;
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
    public ResponseEntity<Footballer> updateFootballer(@RequestBody Footballer footballer){
        Footballer updatedFootballer = footballerService.updateFootballer(footballer);
        return new ResponseEntity<>(updatedFootballer,HttpStatus.OK);
    }
    @DeleteMapping("/deleteFootballer/{id}")
    public ResponseEntity<Footballer> deleteFootballer(@PathVariable Long id){
        footballerService.deleteFootballerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
