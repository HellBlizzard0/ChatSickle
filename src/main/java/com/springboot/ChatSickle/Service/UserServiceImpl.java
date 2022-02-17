package com.springboot.ChatSickle.Service;

import com.springboot.ChatSickle.DAO.UserDAO;
import com.springboot.ChatSickle.Entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aalsaqqa
 */
@Service
public class UserServiceImpl implements UserService {

    UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }


}
