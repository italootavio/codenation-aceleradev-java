package com.challenge.entity.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "acceleration")
public class Acceleration {
    @Id
    private Integer id;

    @Column(nullable = false,length = 100)
    @NotNull
    @Size(max = 100)
    private String name;

    @Column(nullable = false,length = 50)
    @Size(max = 50)
    @NotNull
    private String slug;

    @CreatedDate
    private Timestamp createdAt;

    @ManyToOne
    private Challenge challenge_id;

    @OneToMany
    private  List<Candidate> candidates;
}
