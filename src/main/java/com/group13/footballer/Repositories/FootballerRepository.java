package com.group13.footballer.Repositories;

import com.group13.footballer.Models.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FootballerRepository extends JpaRepository<Footballer,Long>{
    void deleteFootballerById(Long id);
    Optional<Footballer> findFootballerById(Long id);
}
