package com.group13.footballer.Services;

import com.group13.footballer.Models.AvatarImage;
import com.group13.footballer.Models.dto.AvatarImageResponse;
import com.group13.footballer.Repositories.AvatarImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvatarImageService {

    private final AvatarImageRepository avatarImageRepository;

    public List<AvatarImageResponse> getAll(){
        return avatarImageRepository.findAll().stream().map(avatar -> new AvatarImageResponse
                (
                        avatar.getId(),
                        avatar.getUrl()
                )).collect(Collectors.toList());
    }

    protected List<AvatarImage> findByAvatar(List<Long> id){
        return avatarImageRepository.findByIdIn(id);
    }


}
