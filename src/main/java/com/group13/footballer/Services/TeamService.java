package com.group13.footballer.Services;

import com.group13.footballer.core.Exceptions.Constant.Constant;
import com.group13.footballer.core.Exceptions.TeamAlreadyExistException;
import com.group13.footballer.core.Exceptions.TeamNotFound;
import com.group13.footballer.Models.FootballTeam;
import com.group13.footballer.Models.User;
import com.group13.footballer.Models.dto.CreateFootballTeamRequest;
import com.group13.footballer.Repositories.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamService {
    private final TeamRepository teamRepository;

    private final UserService userService;

    public TeamService(TeamRepository teamRepository,UserService userService){
        this.teamRepository = teamRepository;
        this.userService = userService;
    }
    public FootballTeam addTeam(CreateFootballTeamRequest createFootballTeamRequest){
        User user = userService.findById(createFootballTeamRequest.getUserId());

        if(teamRepository.findTeamByUser_UserId(createFootballTeamRequest.getUserId()).isPresent()){
            throw new TeamAlreadyExistException(Constant.TEAM_ALREADY_EXIST);
        }
        FootballTeam footballTeam = new FootballTeam
        (
            createFootballTeamRequest.getFootballTeamName(),
            createFootballTeamRequest.getFootballTeamCapacity(),
            createFootballTeamRequest.getFootballTeamCurrentCount(),
            user
        );

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
