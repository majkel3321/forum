package com.forum.testForum.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@ToString
@Setter
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(min = 3, max = 32)
    private String username;

    @NotNull
    @Length(min = 8, max = 64)
    private String password;

    private boolean isAdmin;

    private boolean isModerator;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Post> posts;

    private LocalDateTime registrationDate;

    private LocalDateTime lastLoginDate;

    public User(@NotNull @Length(min = 3, max = 32) String username, @NotNull @Length(min = 8, max = 64) String password) {
        this.username = username;
        this.password = password;
        this.isAdmin = false;
        this.isModerator = false;
        this.posts = new ArrayList<>();
        this.registrationDate = LocalDateTime.now();
        this.lastLoginDate = LocalDateTime.now();
    }
}
