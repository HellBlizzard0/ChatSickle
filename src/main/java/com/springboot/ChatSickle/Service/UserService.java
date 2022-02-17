package com.springboot.ChatSickle.Service;

import java.util.List;
import com.springboot.ChatSickle.Entity.User;

/**
 *
 * @author aalsaqqa
 */
public interface UserService {
    public List<User> findAll();
}
