package com.salesianostriana.dam.skillhub;

import com.salesianostriana.dam.skillhub.dto.CourseRequestDto;
import com.salesianostriana.dam.skillhub.model.Course;
import com.salesianostriana.dam.skillhub.service.CourseService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final CourseService courseService;

    @PostConstruct
    public void run() {
        CourseRequestDto dto = new CourseRequestDto("Hola mundo", null, List.of(1L, 2L, 3L), null);
        Course course = courseService.createCourse(dto);
        log.info(course.toString());
    }

}
