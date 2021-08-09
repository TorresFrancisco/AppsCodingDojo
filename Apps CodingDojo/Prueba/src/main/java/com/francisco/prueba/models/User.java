package com.francisco.prueba.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users",
        uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends BaseModel {
    @NotNull
    @NotBlank(message="Must have a First Name")
    @Size( min = 2, max = 20, message="Enter a Name between 2 and 20 characters")
    private String firstname;
    @NotNull
    @NotBlank(message="Must have a Last Name")
    @Size( min = 2, max = 20, message="Enter a Last Name between 2 and 20 characters")
    private String lastname;
    @NotNull
    @Column(unique=true)
    @Email(message="Email must be valid")
    private String email;
    @NotNull
    @Size( min = 8, message="Password must be greater than 8 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
    private Date dueDate;
    private int  rol;

    @OneToMany(mappedBy="administrador", fetch = FetchType.LAZY)
    private List<Package> createPack;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="package_id")
    private Package pack;

}