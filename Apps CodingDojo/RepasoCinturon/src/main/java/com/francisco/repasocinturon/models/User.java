package com.francisco.repasocinturon.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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
    @Size( min = 5, max = 20, message="Enter a Name between 5 and 20 characters")
    private String firstname;
    @NotNull
    @NotBlank(message="Must have a Last Name")
    @Size( min = 5, max = 20, message="Enter a Last Name between 5 and 20 characters")
    private String lastname;
    @NotNull
    @Column(unique=true)
    @Email(message="Email must be valid")
    private String email;
    @NotNull
    @NotBlank(message="Must have a Location")
    private String location;
    @NotNull
    @NotBlank(message="Must have a State")
    private String state;
    @NotNull
    @Size( min = 5, message="Password must be greater than 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;

    //un usuario tiene muchos eventos

    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Event> eventsHost;

    //un usuario tiene muchos mensajes

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Message> messages;
//    private List<Message> messages = new ArrayList<>();

    //muchos usuarios pueden asistir a muchos eventos

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "events_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> eventosAsiste;
}
