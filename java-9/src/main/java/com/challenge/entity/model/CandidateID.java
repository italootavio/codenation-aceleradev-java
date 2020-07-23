package com.challenge.entity.model;

import lombok.Data;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class CandidateID implements Serializable {
    @ManyToOne
    private User user_id;
    @ManyToOne
    private Acceleration acceletation_id;
    @ManyToOne
    private Company company_id;
}
