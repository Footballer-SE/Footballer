package com.group13.footballer.Repositories;

import com.group13.footballer.Models.AvatarImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvatarImageRepository extends JpaRepository<AvatarImage,Long> {

    List<AvatarImage> findByIdIn(List<Long> id);
}
