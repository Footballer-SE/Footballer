package com.group13.footballer.Controllers;

import com.group13.footballer.Models.dto.PositionResponse;
import com.group13.footballer.Services.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/position")
@RestController
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;


    @GetMapping
    public ResponseEntity<List<PositionResponse>> getAll(){
        return new ResponseEntity<>(positionService.getAll(), HttpStatus.OK);
    }
}
