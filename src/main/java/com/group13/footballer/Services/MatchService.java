package com.group13.footballer.Services;

import com.group13.footballer.Models.dto.*;
import com.group13.footballer.core.Exceptions.Constant.Constant;
import com.group13.footballer.core.Exceptions.DateIsWrongException;
import com.group13.footballer.core.Exceptions.MatchNotFound;
import com.group13.footballer.Models.Match;
import com.group13.footballer.Repositories.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    private final UserService userService;

    private final AdvertService advertService;


    public CreateMatchResponse addMatch(CreateMatchRequest request) {
        Match match = new Match(userService.findById(request.getUserId()), advertService.findById(request.getAdvertId()));

        dateControl(advertService.getAdvertById(request.getAdvertId()).getDateTime(),request.getUserId());

        matchRepository.save(match);

        return new CreateMatchResponse
                (
                        match.getMatchId(),
                        new UserResponse
                                (
                                        match.getUser().getUserId(),
                                        match.getUser().getUserName(),
                                        match.getUser().getEmail(),
                                        match.getUser().getTelephoneNumber()
                                ),
                        new AdvertResponse
                                (
                                        match.getAdvert().getAdvertId(),
                                        match.getAdvert().getDateTime(),
                                        match.getAdvert().getDescription(),
                                        match.getAdvert().getIsActive(),
                                        new CityResponse(match.getAdvert().getCity().getCityId(), match.getAdvert().getCity().getCityName()),
                                        match.getAdvert().getAdvertType(),
                                        match.getAdvert()
                                                .getPositions()
                                                .stream()
                                                .map(position -> new PositionResponse
                                                        (position.getPositionId(),
                                                                position.getPositionName())).
                                                collect(Collectors.toList())
                                )
                );
    }

    private void dateControl(LocalDateTime dateTime,Long userId) {
        List<Match> matches = matchRepository.findByUser_UserId(userId);

        List<Match> matches1 = matches.stream().filter(match -> match.getAdvert().getDateTime() == dateTime).collect(Collectors.toList());
        if (matches1.size()!=0){
            throw new DateIsWrongException(Constant.DATE_IS_WRONG);
        }
    }

    protected Match findById(Long id) {
        return matchRepository.findById(id).orElseThrow(() -> new MatchNotFound(Constant.MATCH_NOT_FOUND));
    }

    public void deleteMatchById(Long id) {
        matchRepository.deleteById(findById(id).getMatchId());
    }
}
