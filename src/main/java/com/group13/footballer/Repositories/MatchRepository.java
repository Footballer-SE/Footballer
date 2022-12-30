package com.group13.footballer.Repositories;

import com.group13.footballer.Models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MatchRepository extends JpaRepository<Match,Long> {

    List<Match> findByUser_Id(Long id);
}
