package com.group13.footballer.Repositories;

import com.group13.footballer.Models.Advert;
import com.group13.footballer.Models.AdvertType;
import com.group13.footballer.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
