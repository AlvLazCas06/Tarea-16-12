package com.salesianostriana.dam.skillhub.service;

import com.salesianostriana.dam.skillhub.dto.CourseRequestDto;
import com.salesianostriana.dam.skillhub.model.*;
import com.salesianostriana.dam.skillhub.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;
    private final CategoryRepository categoryRepository;

    public Course createCourse(CourseRequestDto dto) {
        Course course = dto.toEntity();
        User user;
        if (dto.userId() != null) {
            try {
                user = userRepository.findById(dto.userId())
                        .orElseThrow(() -> new EntityNotFoundException("El usuario con el id: %d, no existe.".formatted(dto.userId())));
                course.setInstructor(user);
            } catch (EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (dto.lessonsIds() != null) {
            try {
                if (lessonRepository.findAll().isEmpty()) {
                    throw new EntityNotFoundException("No existe");
                }
                dto.lessonsIds().forEach(id -> {
                    course.addLesson(lessonRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("")));

                });
            } catch (EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (dto.categoriesIds() != null) {
            try {
                if (categoryRepository.findAll().isEmpty()) {
                    throw new EntityNotFoundException("No existe");
                }
                dto.categoriesIds().forEach(id -> {
                    course.addCategory(categoryRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("")));

                });
            } catch (EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return courseRepository.save(course);
    }

    public List<Course> getCoursesByCategory(Long id) {
        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getCategories().stream().anyMatch(category -> category.getId().equals(id)))
                .toList();
    }

}
