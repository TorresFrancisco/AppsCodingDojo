package com.francisco.listaestudiantes.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="nombre_id")
    private Nombre nombre;

    public Contacto() {
    }

    public Contacto(Long id, Nombre nombre, String address, String city, String state) {
        this.id = id;
        this.nombre = nombre;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public Contacto(Nombre nombre, String address, String city, String state) {
        this.nombre = nombre;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
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

