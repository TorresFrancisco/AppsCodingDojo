package com.francisco.listaestudiantes.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="nombres")
public class Nombre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(mappedBy="nombre", cascade=CascadeType.ALL, fetch= FetchType.LAZY)
    private Contacto contacto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dorm_id")
    private Dorm dorm;

    public Nombre(){
    }

    public Nombre( String firstName, String lastName, int age ,Dorm dorm ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dorm = dorm;
    }

    public Nombre(Long id, String firstName, String lastName, int age, Dorm dorm){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dorm = dorm;
    }

//    public Dorm getDorm() {
//        return dorm;
//    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
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
