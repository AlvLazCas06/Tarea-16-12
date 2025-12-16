package com.salesianostriana.dam.skillhub.service;

import com.salesianostriana.dam.skillhub.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

}
