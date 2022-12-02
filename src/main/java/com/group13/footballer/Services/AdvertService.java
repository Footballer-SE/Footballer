package com.group13.footballer.Services;

import com.group13.footballer.Exceptions.FootballerNotFound;
import com.group13.footballer.Models.Advert;
import com.group13.footballer.Repositories.AdvertRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdvertService {

    public final AdvertRepository advertRepository;

    public AdvertService(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }


    public ResponseEntity<Advert> addAdvert(Advert advert) {
        advert.setDateTime(new Date());
        advert = advertRepository.save(advert);
        return new ResponseEntity<>(advert, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Advert>> getAllAdverts() {
        List<Advert> adverts = advertRepository.findAll();
        return new ResponseEntity<>(adverts,HttpStatus.OK);
    }

    public ResponseEntity<Advert> getAdvertById(Long id) {
        Advert advert = advertRepository.findById(id).orElseThrow(() -> new FootballerNotFound("Footballer by" + id + "this Id could not be found."));
        return new ResponseEntity<>(advert,HttpStatus.OK);
    }

    public ResponseEntity<Advert> updateAdvertById(Advert advert, Long id) {
            Optional<Advert> advert1 = advertRepository.findById(id);

            if(advert1.isPresent()) {
                Advert newAdvert = advert1.get();
                newAdvert.setDateTime(new Date());
                newAdvert.setActive(advert.isActive());
                newAdvert.setDateTime(advert.getDateTime());
                return new ResponseEntity<>(advertRepository.save(newAdvert), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    public ResponseEntity deleteAdvertById(Long id) {
        Optional<Advert> advert = advertRepository.findById(id);
        if(advert.isPresent()) {
            advertRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
