package com.group13.footballer.Services;

import com.group13.footballer.Models.Position;
import com.group13.footballer.Repositories.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final PositionRepository positionRepository;

    protected List<Position> findByPositions(List<Long> id){
        return positionRepository.findByPositionIdIn(id);
    }
}
