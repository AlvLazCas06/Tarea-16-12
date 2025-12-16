package com.salesianostriana.dam.skillhub.repository;

import com.salesianostriana.dam.skillhub.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
