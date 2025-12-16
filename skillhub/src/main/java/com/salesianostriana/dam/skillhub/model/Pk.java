package com.salesianostriana.dam.skillhub.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Pk {

    private long user_id;

    private long course_id;

}
