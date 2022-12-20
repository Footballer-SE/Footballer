package com.group13.footballer.Controllers;


import com.group13.footballer.Models.Advert;
import com.group13.footballer.Models.dto.AdvertResponse;
import com.group13.footballer.Models.dto.CreateAdvertRequest;
import com.group13.footballer.Services.AdvertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdvertController {

    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @PostMapping("/addAdvert")
    public ResponseEntity<AdvertResponse> addAdvert(@RequestBody CreateAdvertRequest request) {
        return new ResponseEntity<>(advertService.addAdvert(request),HttpStatus.CREATED);
    }

    @GetMapping("/allAdverts")
    public ResponseEntity<List<AdvertResponse>> getAllAdverts(){
        return new ResponseEntity<>(advertService.getAllAdverts(),HttpStatus.OK);
    }

    @GetMapping("/getAdvert/{id}")
    public ResponseEntity<AdvertResponse> getAdvertById(@PathVariable Long id){
        return new ResponseEntity<>(advertService.getAdvertById(id), HttpStatus.OK);
    }


    @DeleteMapping("/deleteAdvert/{id}")
    public ResponseEntity<Void> deleteAdvertById(@PathVariable Long id) {
        advertService.deleteAdvertById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
