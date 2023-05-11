package com.tamartamam.coronaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Person {

    @Id
    private String id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private Date birthDate;

    @Column
    private String phoneNumber;

    @Column
    private String telephoneNumber;

    @JsonIgnoreProperties("person")
    @OneToOne(mappedBy = "person")
    private SickPerson sickPerson;

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public SickPerson getSickPerson() {
        return sickPerson;
    }

    public void setSickPerson(SickPerson sickPerson) {
        this.sickPerson = sickPerson;
    }

    public boolean hasEmptyFields() {
        return this.id == null || this.firstName == null || this.lastName == null || this.address == null || this.birthDate == null || this.phoneNumber == null || this.telephoneNumber == null;
    }
}