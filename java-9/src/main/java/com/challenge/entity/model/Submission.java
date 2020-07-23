package com.challenge.entity.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "submission",schema = "public")
public class Submission {

    @EmbeddedId
    private SubmissionID submissionID;

    @NotNull
    @Column(nullable = false)
    private Float score;

    @CreatedDate
    @NotNull
    private Calendar createdAt;
}
