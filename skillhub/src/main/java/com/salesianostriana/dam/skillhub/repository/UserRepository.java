package com.salesianostriana.dam.skillhub.repository;

import com.salesianostriana.dam.skillhub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
