package com.group13.footballer.Controllers;

import com.group13.footballer.Models.City;
import com.group13.footballer.Models.dto.CityResponse;
import com.group13.footballer.Services.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/allCity")
    public ResponseEntity<List<CityResponse>> getCities(){
        return new ResponseEntity<>(cityService.findAllCities(), HttpStatus.OK);
    }

}
