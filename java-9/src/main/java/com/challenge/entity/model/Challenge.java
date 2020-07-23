package com.challenge.entity.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "challenge",schema = "public")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String slug;

    @CreatedDate
    private Calendar createdAt;

    @OneToMany
    private List<Submission> submissions;

    @OneToMany
    private List<Acceleration> accelerations;
}
