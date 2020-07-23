package com.challenge.entity.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "company")
public class Company {
    @Id
    private Integer id;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false,length = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false,length = 50)
    private String slug;

    @CreatedDate
    private Timestamp createdAt;

    @OneToMany
    private List<Candidate> candidates;
}
