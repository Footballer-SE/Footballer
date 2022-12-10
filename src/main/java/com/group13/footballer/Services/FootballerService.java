package com.group13.footballer.Services;

import com.group13.footballer.Exceptions.FootballerNotFound;
import com.group13.footballer.Models.Footballer;
import com.group13.footballer.Repositories.FootballerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FootballerService {
    public final FootballerRepository footballerRepository;

    @Autowired
    public FootballerService(FootballerRepository footballerRepository){
        this.footballerRepository = footballerRepository;
    }
    public Footballer addFootballer(Footballer footballer){
        return footballerRepository.save(footballer);
    }
    public List<Footballer> findAllFootballers(){
        return footballerRepository.findAll();
    }
    public Footballer updateFootballer(Footballer footballer){
        return footballerRepository.save(footballer);
    }
    public void deleteFootballerById(Long Id){
        footballerRepository.deleteFootballerById(Id);
    }
    public Footballer findFootballerById(Long Id){
        return footballerRepository.findFootballerById(Id).orElseThrow(() -> new FootballerNotFound("Footballer by" + Id + "this Id could not be found."));
    }
}
