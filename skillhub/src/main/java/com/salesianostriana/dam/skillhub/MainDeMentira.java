package com.salesianostriana.dam.skillhub;

import com.salesianostriana.dam.skillhub.dto.CourseRequestDto;
import com.salesianostriana.dam.skillhub.service.CourseService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final CourseService courseService;

    @PostConstruct
    public void run() {
        CourseRequestDto dto = new CourseRequestDto("Hola mundo", null, List.of(1L, 2L, 3L), null);
        courseService.createCourse(dto);
    }

}
