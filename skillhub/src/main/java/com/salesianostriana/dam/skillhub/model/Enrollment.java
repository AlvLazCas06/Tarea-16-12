package com.salesianostriana.dam.skillhub.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Enrollment {

    @EmbeddedId
    private Pk enrollmentPk = new Pk();

    @Builder.Default
    private LocalDate enrolledAt = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    private Course course;

    private int progressPrecent;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Enrollment that = (Enrollment) o;
        return getEnrollmentPk() != null && Objects.equals(getEnrollmentPk(), that.getEnrollmentPk());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(enrollmentPk);
    }
}
