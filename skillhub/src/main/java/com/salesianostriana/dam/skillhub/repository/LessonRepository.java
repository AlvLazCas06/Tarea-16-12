package com.salesianostriana.dam.skillhub.repository;

import com.salesianostriana.dam.skillhub.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
