package com.springboot.ChatSickle.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.ChatSickle.DAO.ChatDAO;
import com.springboot.ChatSickle.DAO.MessageDAO;
import com.springboot.ChatSickle.Entity.Chat;
import com.springboot.ChatSickle.Entity.Message;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatDAO chatDAO;
    private MessageDAO messageDAO;

    public ChatServiceImpl(ChatDAO chatDAO, MessageDAO messageDAO) {
        this.chatDAO = chatDAO;
        this.messageDAO = messageDAO;
    }

    public List<Chat> theDeats() {
        return chatDAO.findAll();
    }

	public void sendMessage(Message message) {
		messageDAO.save(message);
	}

	public void update(Chat chat) {
		chatDAO.save(chat);
	}

	public Chat getChat(int chatId) {
		return chatDAO.getById(chatId);
	}

}
