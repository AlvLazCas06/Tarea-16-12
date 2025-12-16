package com.salesianostriana.dam.skillhub.dto;

import com.salesianostriana.dam.skillhub.model.Course;

import java.util.List;

public record CourseRequestDto(
        String name,
        Long userId,
        List<Long> lessonsIds,
        List<Long> categoriesIds
) {

    public Course toEntity() {
        return Course.builder()
                .name(name)
                .build();
    }

}
