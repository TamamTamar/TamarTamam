package com.tamartamam.coronaapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "personId", referencedColumnName = "id")
    @ManyToOne(targetEntity = Person.class)
    private Person person;

    @JoinColumn(name = "providerId", referencedColumnName = "id")
    @ManyToOne(targetEntity = Provider.class)
    private Provider provider;

    @Column
    private Date date;

    public Vaccination() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
