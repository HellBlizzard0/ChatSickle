package com.springboot.ChatSickle.Service;

import java.util.List;

import com.springboot.ChatSickle.Entity.Chat;
import com.springboot.ChatSickle.Entity.Message;

public interface ChatService {
    public List<Chat> theDeats();

    public void sendMessage(Message message);

    public void update(Chat chat);

    public Chat getChat(int chatId);
}
