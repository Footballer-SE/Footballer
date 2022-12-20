package com.group13.footballer.Repositories;

import com.group13.footballer.Models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,Long> {

    List<Position> findByPositionIdIn(List<Long> id);
}
