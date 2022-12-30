package com.group13.footballer.Services;

import com.group13.footballer.core.Exceptions.CityNotFoundException;
import com.group13.footballer.Models.dto.CityResponse;
import com.group13.footballer.core.Exceptions.Constant.Constant;
import com.group13.footballer.Models.City;
import com.group13.footballer.Repositories.CityRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityService {
   
    
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityResponse> findAllCities(){
        return cityRepository.findAll().stream().map(city -> new CityResponse
                (
                        city.getCityId(),
                        city.getCityName()
                )).collect(Collectors.toList());
    }
    protected City findCityById(Long Id){
        return cityRepository.findById(Id).orElseThrow(() -> new CityNotFoundException(Constant.CITY_NOT_FOUND));
    }
    public List<CityResponse> findAllCitiesbyType(){
        return cityRepository.findAll().stream().map(city -> new CityResponse
                (
                        city.getCityId(),
                        city.getCityName()
                )).collect(Collectors.toList());
    }
}
