package com.group13.footballer.Repositories;

import com.group13.footballer.Models.Advert;
import com.group13.footballer.Models.AdvertType;
import com.group13.footballer.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<Advert,Long> , PagingAndSortingRepository<Advert,Long> {
    List<Advert> findAllByAdvertType(Enum<AdvertType> advertType);
}
