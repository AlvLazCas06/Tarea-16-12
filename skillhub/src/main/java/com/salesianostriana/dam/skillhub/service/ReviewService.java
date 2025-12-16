package com.salesianostriana.dam.skillhub.service;

import com.salesianostriana.dam.skillhub.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

}
