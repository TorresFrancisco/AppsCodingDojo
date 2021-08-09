package com.francisco.repasocinturon.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="events")
public class Event extends BaseModel{
    @NotBlank(message="Must have a Name")
    private String name;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="Must have a Date")
    private Date date;
    @NotBlank(message="Must have a Location")
    private String location;
    @NotBlank(message="Must have a State")
    private String state;

    //muchos a uno

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User host;

    //un evento tiene muchos mensajes

    @OneToMany(mappedBy="event", fetch = FetchType.LAZY)
    private List<Message> messages;
//    private List<Message> messages = new ArrayList<>();
    // muchos a muchos

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "events_users",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usuariosAsisten = new ArrayList<>();

    public void joinUser(User user){
        this.usuariosAsisten.add(user);
    }
}
