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
    private EnrollmentPk enrollmentPk = new EnrollmentPk();

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return progressPrecent == that.progressPrecent && Objects.equals(enrollmentPk, that.enrollmentPk) && Objects.equals(enrolledAt, that.enrolledAt) && status == that.status && Objects.equals(user, that.user) && Objects.equals(course, that.course);
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
