package com.alex.model;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "phones")
@ApiModel("phone")
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id",referencedColumnName = "id")
    private Human human;

    public Phone() {
    }

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
//                ", human=" + human +
                '}';
    }
}

