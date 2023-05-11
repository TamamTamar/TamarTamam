package com.tamartamam.coronaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class SickPerson {
    @Id
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("sickPerson")
    private Person person;

    @Column
    private Date positiveDate;

    @Column
    private Date positiveUntilDate;

    public SickPerson() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getPositiveDate() {
        return positiveDate;
    }

    public void setPositiveDate(Date positiveDate) {
        this.positiveDate = positiveDate;
    }

    public Date getPositiveUntilDate() {
        return positiveUntilDate;
    }

    public void setPositiveUntilDate(Date positiveUntilDate) {
        this.positiveUntilDate = positiveUntilDate;
    }
}
