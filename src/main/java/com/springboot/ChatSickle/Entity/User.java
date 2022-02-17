package com.springboot.ChatSickle.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Override
    public String toString() {
        return "User [dateOfCreation=" + dateOfCreation + ", id=" + id + ", name=" + name + "]";
    }

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_creation")
    private java.sql.Timestamp dateOfCreation;

    public User() {
    }

    public User(String name, Timestamp dateOfCreation) {
        this.name = name;
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
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

}