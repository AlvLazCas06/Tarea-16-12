package com.salesianostriana.dam.skillhub.service;

import com.salesianostriana.dam.skillhub.model.Course;
import com.salesianostriana.dam.skillhub.model.Enrollment;
import com.salesianostriana.dam.skillhub.model.User;
import com.salesianostriana.dam.skillhub.repository.CourseRepository;
import com.salesianostriana.dam.skillhub.repository.EnrollmentRepository;
import com.salesianostriana.dam.skillhub.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public Enrollment createEnrollment(Enrollment enrollment, Long userId, Long courseId) {
        User user;
        Course course;
        try {
            user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("El usuario con el id: %d, no existe.".formatted(userId)));
            enrollment.setUser(user);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new EntityNotFoundException("El curso con el id: %d, no existe.".formatted(courseId)));
            enrollment.setCourse(course);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        return enrollmentRepository.save(enrollment);
    }

}
