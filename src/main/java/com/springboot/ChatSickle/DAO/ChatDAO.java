package com.springboot.ChatSickle.DAO;

import com.springboot.ChatSickle.Entity.Chat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatDAO extends JpaRepository<Chat, Integer> {

}
