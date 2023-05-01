package com.acme.sprocket.repository;

import com.acme.sprocket.persistence.Sprocket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface SprocketRepository extends JpaRepository<Sprocket, UUID> {
    Optional<Sprocket> findOneByName(String name);
}
