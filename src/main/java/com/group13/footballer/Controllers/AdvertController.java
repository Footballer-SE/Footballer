package com.group13.footballer.Controllers;


import com.group13.footballer.Models.Advert;
import com.group13.footballer.Services.AdvertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://footballerfe.netlify.app/")
public class AdvertController {
    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @PostMapping("/addAdvert")
    public ResponseEntity<Advert> addAdvert(@RequestBody Advert advert) {
        return advertService.addAdvert(advert);
    }

    @GetMapping("/allAdverts")
    public ResponseEntity<List<Advert>> getAllAdverts(){
        return advertService.getAllAdverts();
    }

    @GetMapping("/getAdvert/{id}")
    public ResponseEntity<Advert> getAdvertById(@PathVariable Long id){
        return advertService.getAdvertById(id);
    }
    @PutMapping("/updateAdvert/{id}")
    public ResponseEntity<Advert> updateAdvertById(@RequestBody Advert advert, @PathVariable Long id) {
        return advertService.updateAdvertById(advert,id);
    }
    @DeleteMapping("/deleteAdvert/{id}")
    public ResponseEntity deleteAdvertById(@PathVariable Long id) {
        return advertService.deleteAdvertById(id);

    }

}
