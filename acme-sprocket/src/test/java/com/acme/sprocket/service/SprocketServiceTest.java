package com.acme.sprocket.service;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class SprocketServiceTest {
    private SprocketService sprocketService;

    @BeforeEach
    public void setUp() {
        sprocketService = new SprocketServiceImpl();
    }

    @Test
    public void findOneByIdSuccess() {
        // GIVEN - a valid identifier
        UUID uuid = UUID.randomUUID();

        // WHEN - we request a sprocket by id
        SprocketResponseDTO response = sprocketService.findOne(uuid);

        // THEN - the sprocket is returned
        BDDAssertions.then(response.getId()).isEqualTo(uuid);
    }
}
