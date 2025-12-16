package com.salesianostriana.dam.skillhub.repository;

import com.salesianostriana.dam.skillhub.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
