package com.challenge.entity.model;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullname")
    @NotNull
    @Size(max = 100)
    private String full_name;

    @NotNull
    @Size(max = 100)
    @Email
    private String email;

    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;

    @Column(nullable = false)
    @CreatedDate
    private Calendar createdAt;

    @OneToMany
    private List<Submission> submissions;

    @OneToMany
    private List<Candidate> candidates;
}
