package com.group13.footballer.Controllers;

import com.group13.footballer.Models.dto.AvatarImageResponse;
import com.group13.footballer.Services.AvatarImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/avatar")
@RestController
@RequiredArgsConstructor
public class AvatarImageController {

    private final AvatarImageService avatarImageService;


    @GetMapping
    public ResponseEntity<List<AvatarImageResponse>> getAll(){
        return new ResponseEntity<>(avatarImageService.getAll(), HttpStatus.OK);
    }
}
