package com.francisco.relationships.models;

import javax.persistence.*;
import java.util.Date;
import java.lang.String;

@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch= FetchType.LAZY)
    private License license;

    public Person(){
    }

    public Person( String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
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
