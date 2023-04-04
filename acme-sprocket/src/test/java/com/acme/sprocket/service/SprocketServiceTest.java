package com.acme.sprocket.service;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
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

    @Test
    public void findOneByIdFailure() {
        fail("findOneByIdFailure() not yet implemented");
    }

    @Test
    public void findAllSuccess() {
        fail("findAllSuccess() not yet implemented");
    }

    @Test
    public void updateSuccess() {
        fail("updateSuccess() not yet implemented");
    }

    @Test
    public void updateFailure() {
        fail("updateFailure() not yet implemented");
    }

    @Test
    public void deleteSuccess() {
        fail("deleteSuccess() not yet implemented");
    }


}
