package com.salesianostriana.dam.skillhub.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class EnrollmentPk {

    private long user_id;

    private long course_id;

}
