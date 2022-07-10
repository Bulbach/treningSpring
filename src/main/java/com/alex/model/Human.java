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

    @OneToMany(mappedBy = "human", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column
    private List<Phone> phones = new ArrayList<>();

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
    private LocalDate birthday;


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
//        phones.forEach(p->p.setHuman(this));
    }

    public void setPhone(Phone phone) {
        if(phone == null){
            throw new IllegalArgumentException("Phone for Human id="+id+" is null");
        }
        phone.setHuman(this);
        phones.add(phone);
    }

    public void removePhone(Phone phone){
        if(phone == null){
            throw new IllegalArgumentException("Phone for Human id="+id+" is null");
        }
        phone.setHuman(null);
        phones.remove(phone);
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

