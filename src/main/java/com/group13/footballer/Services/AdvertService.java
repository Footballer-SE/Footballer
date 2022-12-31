package com.group13.footballer.Services;


import com.group13.footballer.Models.City;
import com.group13.footballer.Models.Position;
import com.group13.footballer.Models.User;
import com.group13.footballer.Models.converter.AdvertTypeConverter;
import com.group13.footballer.Models.dto.*;
import com.group13.footballer.core.Exceptions.Constant.Constant;
import com.group13.footballer.core.Exceptions.DateIsWrongException;
import com.group13.footballer.core.Exceptions.FootballerNotFound;
import com.group13.footballer.Models.Advert;
import com.group13.footballer.Repositories.AdvertRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.Period;

import java.util.List;

import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdvertService {

    private final AdvertRepository advertRepository;

    private final CityService cityService;

    private final PositionService positionService;

    private final AdvertTypeConverter advertTypeConverter;

    private final UserService userService;

    public AdvertResponse addAdvert(CreateAdvertRequest request) {
        City city = cityService.findCityById(request.getCityId());
        List<Position> byPositions = positionService.findByPositions(request.getPositionIds());
        User user = userService.findById(request.getId());
        controlDate(request.getDateTime());

        Advert advert = new Advert
                (
                        request.getDateTime(),
                        request.getDescription(),
                        request.getIsActive(),
                        city,
                        advertTypeConverter.convert(request.getAdvertType()),
                        user,
                        byPositions

                );
        advertRepository.save(advert);

        return new AdvertResponse(
                advert.getAdvertId(),
                advert.getDateTime(),
                advert.getDescription(),
                advert.getIsActive(),
                new CityResponse(advert.getCity().getCityId(), advert.getCity().getCityName()),
                new UserResponse(advert.getUser().getId(),advert.getUser().getName(),advert.getUser().getEmail(),advert.getUser().getTelephoneNumber()),
                advert.getAdvertType(),
                byPositions.stream().map(position -> new PositionResponse
                        (
                                position.getPositionId(),
                                position.getPositionName()
                        )).collect(Collectors.toList())

        );
    }

    private void controlDate(LocalDateTime dateTime) {
        if (dateTime.isBefore(LocalDateTime.now()) || dateTime.isAfter(LocalDateTime.now().plus(Period.ofMonths(1)))) {
            throw new DateIsWrongException(Constant.DATE_IS_WRONG);
        }
    }

    public List<AdvertResponse> getAllAdverts() {
        List<Advert> adverts = advertRepository.findAll();
        return adverts.stream().map(advert -> new AdvertResponse
                (
                        advert.getAdvertId(),
                        advert.getDateTime(),
                        advert.getDescription(),
                        advert.getIsActive(),
                        new CityResponse(advert.getCity().getCityId(), advert.getCity().getCityName()),
                        new UserResponse(advert.getUser().getId(),advert.getUser().getName(),advert.getUser().getEmail(),advert.getUser().getTelephoneNumber()),
                        advert.getAdvertType(),
                        advert.getPositions().stream().map(position -> new PositionResponse
                                (
                                        position.getPositionId(),
                                        position.getPositionName()
                                )).collect(Collectors.toList())

                )).collect(Collectors.toList());
    }

    public AdvertResponse getAdvertById(Long id) {
        Advert advert = findById(id);
        return new AdvertResponse
                (
                        advert.getAdvertId(),
                        advert.getDateTime(),
                        advert.getDescription(),
                        advert.getIsActive(),
                        new CityResponse(advert.getCity().getCityId(), advert.getCity().getCityName()),
                        new UserResponse(advert.getUser().getId(),advert.getUser().getName(),advert.getUser().getEmail(),advert.getUser().getTelephoneNumber()),
                        advert.getAdvertType(),
                        advert
                                .getPositions()
                                .stream()
                                .map(position -> new PositionResponse
                                        (position.getPositionId(),
                                                position.getPositionName())).
                                collect(Collectors.toList())

                );
    }

    protected Advert findById(Long id) {
        return advertRepository.findById(id).orElseThrow
                (() -> new FootballerNotFound("Footballer by" + id + "this Id could not be found."));
    }


    public void deleteAdvertById(Long id) {
        advertRepository.deleteById(findById(id).getAdvertId());
    }
}
