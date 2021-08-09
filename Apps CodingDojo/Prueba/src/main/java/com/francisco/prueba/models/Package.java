package com.francisco.prueba.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="packages")
public class Package extends BaseModel{
    @NotNull
    @NotBlank(message="Name must be present")
    private String name;
    private double cost;
    private boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="administrador_id")
    private User administrador;

    @OneToMany(mappedBy="pack", fetch = FetchType.LAZY)
    private List<User> userSuscribed;


}
