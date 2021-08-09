package com.francisco.listaestudiantes.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="dorms")
public class Dorm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="dorm",fetch= FetchType.LAZY)
    private List<Nombre> nombres;

    public Dorm() {
    }

    public Dorm(String name) {
        this.name = name;
    }

    public Dorm(Long id, String name, List<Nombre> nombres) {
        this.id = id;
        this.name = name;
        this.nombres = nombres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Nombre> getNombres() {
        return nombres;
    }

    public void setNombres(List<Nombre> nombres) {
        this.nombres = nombres;
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
