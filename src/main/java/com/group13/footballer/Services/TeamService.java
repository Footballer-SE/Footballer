package com.group13.footballer.Services;

import com.group13.footballer.Exceptions.FootballerNotFound;
import com.group13.footballer.Exceptions.TeamNotFound;
import com.group13.footballer.Models.FootballTeam;
import com.group13.footballer.Models.Footballer;
import com.group13.footballer.Repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamService {
    public final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }
    public FootballTeam addTeam(FootballTeam footballTeam){
        return teamRepository.save(footballTeam);
    }
    public List<FootballTeam> findAllTeams(){
        return teamRepository.findAll();
    }
    public FootballTeam updateTeam(FootballTeam footballTeam){
        return teamRepository.save(footballTeam);
    }
    public void deleteTeamById(Long Id){
        teamRepository.deleteFootballTeamById(Id);
    }
    public FootballTeam findTeamById(Long Id){
        return teamRepository.findFootballTeamById(Id).orElseThrow(() -> new TeamNotFound("Team by" + Id + "this Id could not be found."));
    }
}
