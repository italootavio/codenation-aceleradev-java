package com.challenge.entity.model;
import lombok.Data;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class SubmissionID implements Serializable {
    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;
}
