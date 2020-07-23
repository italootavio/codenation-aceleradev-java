package com.challenge.entity.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "candidate")
public class Candidate {

    @EmbeddedId
    CandidateID candidateID;


    @Column(nullable = false)
    @NotNull
    private Integer status;

    @CreatedDate
    private Calendar createdAt;

}
