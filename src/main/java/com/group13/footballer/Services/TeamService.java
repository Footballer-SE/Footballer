package com.group13.footballer.Services;

import com.group13.footballer.Exceptions.TeamNotFound;
import com.group13.footballer.Models.FootballTeam;
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
    public FootballTeam updateTeam(Long id, FootballTeam footballTeam){
        FootballTeam updateTeam = teamRepository.findById(id).orElseThrow(() -> new TeamNotFound("Team by" + id + "this Id could not be found."));

        updateTeam.setFootballTeamCapacity(footballTeam.getFootballTeamCapacity());
        updateTeam.setFootballTeamCurrentCount(footballTeam.getFootballTeamCurrentCount());
        updateTeam.setFootballTeamName(footballTeam.getFootballTeamName());
        return teamRepository.save(updateTeam);
    }
    public void deleteTeamById(Long Id){
        teamRepository.deleteById(Id);
    }
    public FootballTeam findTeamById(Long Id){
        return teamRepository.findById(Id).orElseThrow(() -> new TeamNotFound("Team by" + Id + "this Id could not be found."));
    }
}
