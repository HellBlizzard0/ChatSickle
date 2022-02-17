package com.springboot.ChatSickle.DAO;

import com.springboot.ChatSickle.Entity.Message;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageDAO extends JpaRepository<Message, Integer> {

    @Query(value = "from Message m where m.chatId = ?1")
    public List<Message> findByChatId(int chatId);
}
