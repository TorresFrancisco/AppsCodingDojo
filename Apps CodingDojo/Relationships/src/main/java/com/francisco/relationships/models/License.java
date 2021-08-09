package com.francisco.relationships.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="licenses")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;

    public License() {
    }

    public License(Long id, Person person, String number, Date expirationDate, String state) {
        this.id = id;
        this.person = person;
        this.number = number;
        this.expirationDate = expirationDate;
        this.state = state;
    }

    public License(Person person, String number, Date expirationDate, String state) {
        this.person = person;
        this.number = number;
        this.expirationDate = expirationDate;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
