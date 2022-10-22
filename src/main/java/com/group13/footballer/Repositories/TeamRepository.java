package com.group13.footballer.Repositories;

import com.group13.footballer.Models.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<FootballTeam,Long> {
    void deleteFootballTeamById(Long id);
    Optional<FootballTeam> findFootballTeamById(Long id);
}
