/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springboot.ChatSickle.Service;

import com.springboot.ChatSickle.Entity.Message;
import java.util.List;

/**
 *
 * @author aalsaqqa
 */
public interface MessageService {
    public List<Message> findAll();
    public List<Message> findByChatId(int id);
}
