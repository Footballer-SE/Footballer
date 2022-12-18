package com.group13.footballer.Repositories;

import com.group13.footballer.Models.Matchx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Matchx,Long> {
}
