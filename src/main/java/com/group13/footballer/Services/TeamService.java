package com.group13.footballer.Services;

import com.group13.footballer.Models.AvatarImage;
import com.group13.footballer.Models.dto.*;
import com.group13.footballer.core.Exceptions.Constant.Constant;
import com.group13.footballer.core.Exceptions.TeamAlreadyExistException;
import com.group13.footballer.core.Exceptions.TeamNotFound;
import com.group13.footballer.Models.FootballTeam;
import com.group13.footballer.Models.User;
import com.group13.footballer.Repositories.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeamService {
    private final TeamRepository teamRepository;

    private final UserService userService;

    private final AvatarImageService avatarImageService;

    public TeamService(TeamRepository teamRepository, UserService userService, AvatarImageService avatarImageService) {
        this.teamRepository = teamRepository;
        this.userService = userService;
        this.avatarImageService = avatarImageService;
    }

    public void addTeam(CreateFootballTeamRequest createFootballTeamRequest) {
        User user = userService.findById(createFootballTeamRequest.getId());
        AvatarImage avatarImage = avatarImageService.findImageById(createFootballTeamRequest.getAvatarImageId());
//TODO matchı sıl
        if (teamRepository.findTeamByUser_Id(createFootballTeamRequest.getId()).isPresent()) {
            throw new TeamAlreadyExistException(Constant.TEAM_ALREADY_EXIST);
        }
        FootballTeam footballTeam = new FootballTeam
                (
                        createFootballTeamRequest.getId(),
                        createFootballTeamRequest.getFootballTeamName(),
                        createFootballTeamRequest.getFootballTeamCapacity(),
                        createFootballTeamRequest.getFootballTeamCurrentCount(),
                        user,
                        avatarImage


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
                                ),
                        new AvatarImageResponse(updatedFootballTeam.getAvatarImage().getId(),updatedFootballTeam.getAvatarImage().getUrl())

                );
    }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(findTeamById(id).getId());
    }

    public FootballTeam findTeamById(Long id) {
        return teamRepository.findTeamById(id).orElseThrow(() -> new TeamNotFound("Team by" + id + "this Id could not be found."));
    }
    public FootballTeamResponse getTeamById(Long id) {
        FootballTeam team = findTeamById(id);
        return new FootballTeamResponse
                (
                        team.getId(),
                        team.getFootballTeamName(),
                        team.getFootballTeamCapacity(),
                        team.getFootballTeamCurrentCount(),
                        new UserResponse(team.getUser().getId(),team.getUser().getName(),team.getUser().getEmail(),team.getUser().getTelephoneNumber()),
                        new AvatarImageResponse(team.getAvatarImage().getId(),team.getAvatarImage().getUrl())
                );
    }
    public List<FootballTeamResponse> getAllTeams() {
        List<FootballTeam> teams = teamRepository.findAll();
        return teams.stream().map(team -> new FootballTeamResponse
                (
                        team.getId(),
                        team.getFootballTeamName(),
                        team.getFootballTeamCapacity(),
                        team.getFootballTeamCurrentCount(),
                        new UserResponse(team.getUser().getId(),team.getUser().getName(),team.getUser().getEmail(),team.getUser().getTelephoneNumber()),
                        new AvatarImageResponse(team.getAvatarImage().getId(),team.getAvatarImage().getUrl())
                )).collect(Collectors.toList());
    }
}
