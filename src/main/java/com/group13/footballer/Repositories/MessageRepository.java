package com.group13.footballer.Repositories;

import com.group13.footballer.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MessageRepository extends JpaRepository<Message, Long> {

}