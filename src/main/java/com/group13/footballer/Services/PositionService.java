package com.group13.footballer.Services;

import com.group13.footballer.Models.Position;
import com.group13.footballer.Models.dto.PositionResponse;
import com.group13.footballer.Repositories.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final PositionRepository positionRepository;

    public List<PositionResponse> getAll(){
        return positionRepository.findAll().stream().map(position -> new PositionResponse
                (
                        position.getPositionId(),
                        position.getPositionName()
                )).collect(Collectors.toList());
    }

    protected List<Position> findByPositions(List<Long> id){
        return positionRepository.findByPositionIdIn(id);
    }
}
