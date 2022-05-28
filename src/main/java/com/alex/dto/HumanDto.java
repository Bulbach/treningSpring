package com.alex.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HumanDto {

    private Long id;

    private String lastname; // Фамилия
    private String firstname;
    private String city;
    private String street;


    private List<PhoneDto> phoneDtoList;

    private String birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public List<PhoneDto> getPhoneDtoList() {
        return phoneDtoList;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPhoneDtoList(List<PhoneDto> phoneDtoList) {
        this.phoneDtoList = phoneDtoList;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
