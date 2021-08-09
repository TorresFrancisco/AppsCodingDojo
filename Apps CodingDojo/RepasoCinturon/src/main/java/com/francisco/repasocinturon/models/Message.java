package com.francisco.repasocinturon.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="messages")
public class Message extends BaseModel{
    @NotBlank(message="Must have a description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;
}
