package com.salesianostriana.dam.skillhub.repository;

import com.salesianostriana.dam.skillhub.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
