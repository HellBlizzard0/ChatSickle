package com.springboot.ChatSickle.Entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
    @Column(name = "body")
    private String body;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date_of_creation")
    private java.sql.Timestamp dateOfCreation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "init_id", referencedColumnName = "id")
    private User initUser;

    @Column(name = "chat_Id")
    private int chatId;

    public Message(String body, int id, Timestamp dateOfCreation, User initUser, int chatId) {
        this.body = body;
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.initUser = initUser;
        this.chatId = chatId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public Message() {
    }

    /**
     * @return String return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return java.sql.Timestamp return the dateOfCreation
     */
    public java.sql.Timestamp getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * @param dateOfCreation the dateOfCreation to set
     */
    public void setDateOfCreation(java.sql.Timestamp dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    /**
     * @return User return the initUser
     */
    public User getInitUser() {
        return initUser;
    }

    /**
     * @param initUser the initUser to set
     */
    public void setInitUser(User initUser) {
        this.initUser = initUser;
    }

    @Override
    public String toString() {
        return "Message [body=" + body + ", dateOfCreation=" + dateOfCreation + ", id=" + id + ", initUser=" + initUser
                + "]";
    }

}
