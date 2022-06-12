package com.alex.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "humans")
public class Human implements Serializable {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String lastname; // Фамилия
    @Column
    private String firstname;
    @Column
    private String city;
    @Column
    private String street;

    @OneToMany(mappedBy = "human",cascade = CascadeType.ALL,orphanRemoval = true)
    @Column
    private List<Phone> phones = new ArrayList<>();

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
    private LocalDate birthday;

    public Human() {
    }

    public Human(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Human(Long id, String lastname, String firstname, String city, String street,LocalDate birthday) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.city = city;
        this.street = street;
        this.birthday = birthday;
    }

    public Human(Long id, String lastname, String firstname, String city, String street, List<Phone> phones, LocalDate birthday) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.city = city;
        this.street = street;
        this.phones = phones;
        this.birthday = birthday;
    }

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayValue() {
        return this.birthday != null ? DATE_FORMAT.format(this.birthday) : "";
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phonenum) {
        this.phones = phonenum;
    }
    public void setPhones(Phone phone){
        phones.add(phone);
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

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
//                ", phones=" + phones +
                ", birthday=" + birthday +
                '}';
    }
}

