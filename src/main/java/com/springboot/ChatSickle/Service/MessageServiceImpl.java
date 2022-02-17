package com.springboot.ChatSickle.Service;

import com.springboot.ChatSickle.DAO.MessageDAO;
import com.springboot.ChatSickle.Entity.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aalsaqqa
 */
@Service
public class MessageServiceImpl implements MessageService {

    MessageDAO messageDAO;

    @Autowired
    public MessageServiceImpl(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    public List<Message> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Message> findByChatId(int id) {
        return messageDAO.findByChatId(id);
    }

}
