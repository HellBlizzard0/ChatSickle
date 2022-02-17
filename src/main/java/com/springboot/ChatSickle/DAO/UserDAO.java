package com.springboot.ChatSickle.DAO;

import com.springboot.ChatSickle.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

}
