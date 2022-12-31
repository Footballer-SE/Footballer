package com.group13.footballer.Services;

import com.group13.footballer.Models.dto.FootballTeamResponse;
import com.group13.footballer.Models.dto.UpdateFootballTeamRequest;
import com.group13.footballer.Models.dto.UserResponse;
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

    public TeamService(TeamRepository teamRepository, UserService userService) {
        this.teamRepository = teamRepository;
        this.userService = userService;
    }

    public void addTeam(CreateFootballTeamRequest createFootballTeamRequest) {
        User user = userService.findById(createFootballTeamRequest.getId());
//TODO matchı sıl
        if (teamRepository.findTeamByUser_Id(createFootballTeamRequest.getId()).isPresent()) {
            throw new TeamAlreadyExistException(Constant.TEAM_ALREADY_EXIST);
        }
        FootballTeam footballTeam = new FootballTeam
                (
                        createFootballTeamRequest.getFootballTeamName(),
                        createFootballTeamRequest.getFootballTeamCapacity(),
                        createFootballTeamRequest.getFootballTeamCurrentCount(),
                        user
                );
        teamRepository.save(footballTeam);

    }

    public FootballTeamResponse updateTeam(UpdateFootballTeamRequest request) {
        FootballTeam updateTeam = findTeamById(request.getId());

        updateTeam.setFootballTeamCapacity(request.getFootballTeamCapacity());
        updateTeam.setFootballTeamCurrentCount(request.getFootballTeamCurrentCount());
        updateTeam.setFootballTeamName(request.getFootballTeamName());
        FootballTeam updatedFootballTeam = teamRepository.save(updateTeam);
        return new FootballTeamResponse
                (
                        updatedFootballTeam.getId(),
                        updatedFootballTeam.getFootballTeamName(),
                        updatedFootballTeam.getFootballTeamCapacity(),
                        updatedFootballTeam.getFootballTeamCurrentCount(),
                        new UserResponse
                                (
                                        updatedFootballTeam.getUser().getId(),
                                        updatedFootballTeam.getUser().getName(),
                                        updatedFootballTeam.getUser().getEmail(),
                                        updatedFootballTeam.getUser().getTelephoneNumber()
                                )
                );
    }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(findTeamById(id).getId());
    }

    public FootballTeam findTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFound("Team by" + id + "this Id could not be found."));
    }
}
