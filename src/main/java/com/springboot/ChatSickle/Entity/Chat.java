package com.springboot.ChatSickle.Entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chat")
public class Chat {
    @Column(name = "date_of_creation")
    private java.sql.Timestamp dateOfCreation;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public Chat() {
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "init_id", referencedColumnName = "id")
    private User initUser;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "other_id", referencedColumnName = "id")
    private User otherUser;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "chat_id")
    private List<Message> messages;

    public Chat(Timestamp dateOfCreation, User initUser, User otherUser, List<Message> messages) {
        this.dateOfCreation = dateOfCreation;
        this.initUser = initUser;
        this.otherUser = otherUser;
        this.messages = messages;
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

    /**
     * @return User return the otherUser
     */
    public User getOtherUser() {
        return otherUser;
    }

    /**
     * @param otherUser the otherUser to set
     */
    public void setOtherUser(User otherUser) {
        this.otherUser = otherUser;
    }

    /**
     * @return List<Message> return the messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Chat [dateOfCreation=" + dateOfCreation + ", id=" + id + ", initUser=" + initUser + ", messages="
                + messages + ", otherUser=" + otherUser + "]";
    }


}
