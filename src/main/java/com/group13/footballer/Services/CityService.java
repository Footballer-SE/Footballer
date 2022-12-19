package com.group13.footballer.Services;

import com.group13.footballer.Exceptions.FootballerNotFound;
import com.group13.footballer.Models.City;
import com.group13.footballer.Repositories.CityRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CityService {
   
    
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAllCities(){
        return cityRepository.findAll();
    }
    public City findCityById(Long Id){
        return cityRepository.findById(Id).orElseThrow(() -> new FootballerNotFound("City by" + Id + "this Id could not be found."));
    }
}
