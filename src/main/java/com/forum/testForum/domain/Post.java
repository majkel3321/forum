package com.forum.testForum.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@NoArgsConstructor
@Entity
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = 1, max = 30)
    private String subject;

    @NotNull
    @Length(min = 1, max = 5000)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime dateTime;

    public Post(@NotNull @Length(min = 1, max = 30) String subject, @NotNull @Length(min = 1, max = 5000) String message, User user) {
        this.subject = subject;
        this.message = message;
        this.user = user;
        this.dateTime = LocalDateTime.now();
    }
}
