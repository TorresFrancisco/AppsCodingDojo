package com.francisco.dojooverflow.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tags_questions",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;

    public Tag(String subject) {
        this.subject = subject;
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
