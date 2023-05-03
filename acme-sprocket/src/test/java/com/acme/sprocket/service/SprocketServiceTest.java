package com.acme.sprocket.service;

import com.acme.sprocket.common.data.page.Page;
import com.acme.sprocket.exception.SprocketNotFoundException;
import com.acme.sprocket.persistence.Sprocket;
import com.acme.sprocket.repository.SprocketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

import static com.acme.sprocket.common.data.page.PageRequestUtility.pageRequest;
import static java.util.Collections.singletonList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SprocketServiceTest {
    private SprocketService sprocketService;
    private SprocketInsertDTO sprocketInsertRequest;
    private Sprocket sprocket;

    @Mock
    private SprocketRepository sprocketRepository;

    @BeforeEach
    public void setUp() {
        sprocketService = new SprocketServiceImpl(sprocketRepository);

        // mock the method calls
        sprocket = new Sprocket("Spacely Vibranium 3", 4,6,1);
        sprocket.setId(randomUUID());
        given(sprocketRepository.saveAndFlush(any())).willReturn(sprocket);
//        given(sprocketRepository.findById(any())).willReturn(of(sprocket));

        sprocketInsertRequest = new SprocketInsertDTO(
                "Spacely Vibranium 3",
                4,
                6,
                1
        );
    }

    @Test
    public void insertSprocketSuccess() {
        // GIVEN - valid input for a Sprocket

        // WHEN
        SprocketResponseDTO sprocketInsertResponse = sprocketService.insert(sprocketInsertRequest);

        // THEN
        then(sprocketInsertResponse.getName()).isEqualTo(sprocketInsertRequest.getName());
        then(sprocketInsertResponse.getPitchDiameterInches()).isEqualTo(sprocketInsertRequest.getPitchDiameterInches());
        then(sprocketInsertResponse.getOutsideDiameterInches()).isEqualTo(sprocketInsertRequest.getOutsideDiameterInches());
        then(sprocketInsertResponse.getPitchInches()).isEqualTo(sprocketInsertRequest.getPitchInches());
    }

    @Test
    public void updateSprocketSuccess() {
        // GIVEN - valid input for a Sprocket
        SprocketResponseDTO sprocketInsertResponse = sprocketService.insert(sprocketInsertRequest);
        SprocketUpdateDTO sprocketUpdateRequest = new SprocketUpdateDTO(
                sprocketInsertResponse.getId(),
                sprocketInsertResponse.getName() + "_xyz",
                sprocketInsertResponse.getPitchDiameterInches() + 2,
                sprocketInsertResponse.getOutsideDiameterInches() + 2,
                sprocketInsertResponse.getPitchInches() + 2);

        // set up mock for the update call
        given(sprocketRepository.findById(any())).willReturn(of(sprocket));

        // WHEN
        SprocketResponseDTO sprocketUpdateResponse =
                sprocketService.update(sprocketUpdateRequest.getId(), sprocketUpdateRequest);

        // THEN
        then(sprocketUpdateResponse.getName()).isEqualTo(sprocketInsertResponse.getName() + "_xyz");
        then(sprocketUpdateResponse.getPitchDiameterInches()).isEqualTo(sprocketInsertResponse.getPitchDiameterInches() + 2);
        then(sprocketUpdateResponse.getOutsideDiameterInches()).isEqualTo(sprocketInsertResponse.getOutsideDiameterInches() + 2);
        then(sprocketUpdateResponse.getPitchInches()).isEqualTo(sprocketInsertResponse.getPitchInches() + 2);
    }

    @Test
    public void updateSprocketNotFound() {
        // GIVEN - valid input for a Sprocket
        SprocketResponseDTO sprocketInsertResponse = sprocketService.insert(sprocketInsertRequest);
        UUID invalidUUID = randomUUID();
        SprocketUpdateDTO sprocketUpdateRequest = new SprocketUpdateDTO(
                invalidUUID,
                sprocketInsertResponse.getName() + "_xyz",
                sprocketInsertResponse.getPitchDiameterInches() + 2,
                sprocketInsertResponse.getOutsideDiameterInches() + 2,
                sprocketInsertResponse.getPitchInches() + 2);

        // set up mock calls for update
        SprocketNotFoundException expectedException = new SprocketNotFoundException(invalidUUID);
        given(sprocketRepository.findById(any())).willThrow(expectedException);

        // WHEN - update with an invalid UUID
        try {
            SprocketResponseDTO sprocketUpdateResponse =
                    sprocketService.update(sprocketUpdateRequest.getId(), sprocketUpdateRequest);
        } catch (SprocketNotFoundException actualException) {
            // THEN
            then(expectedException.toString()).isEqualTo(actualException.toString());
        }
    }

    @Test
    public void findOneByIdSuccess() {
        // GIVEN - a Sprocket that has already been inserted
        SprocketResponseDTO sprocketInsertResponse = sprocketService.insert(sprocketInsertRequest);

        // set up mock for the findById call
        given(sprocketRepository.findById(any())).willReturn(of(sprocket));

        // WHEN - we request a sprocket by id
        SprocketResponseDTO response = sprocketService.findOne(sprocketInsertResponse.getId());

        // THEN - the sprocket is returned
        then(response.getId()).isEqualTo(sprocketInsertResponse.getId());
    }

    @Test
    public void findOneByIdSprocketNotFound() {
        // GIVEN - a Sprocket that has already been inserted
        SprocketResponseDTO sprocketInsertResponse = sprocketService.insert(sprocketInsertRequest);

        // set up mock for the find call
        given(sprocketRepository.findById(any())).willReturn(of(sprocket));

        // set up mock calls for update
        UUID invalidUUID = randomUUID();
        SprocketNotFoundException expectedException = new SprocketNotFoundException(invalidUUID);
        given(sprocketRepository.findById(any())).willThrow(expectedException);

        // WHEN - find using an invalid uuid
        try {
            SprocketResponseDTO response = sprocketService.findOne(invalidUUID);
        } catch (SprocketNotFoundException actualException) {
            // THEN
            then(expectedException.toString()).isEqualTo(actualException.toString());
        }
    }

    @Test
    public void findAllSuccess() {
        // GIVEN - a Sprocket that has already been inserted
        SprocketResponseDTO sprocketInsertResponse = sprocketService.insert(sprocketInsertRequest);

        // set up mock for the findAll call
        org.springframework.data.domain.Page<Sprocket> page =
                new PageImpl<Sprocket>(singletonList(sprocket), PageRequest.of(0, 10), 1);
        given(sprocketRepository.findAll(pageRequest(empty(), empty()))).willReturn(page);

        // WHEN
        Page<SprocketResponseDTO> sprocketResponsePage = sprocketService.findAll(new SprocketFindAllRequest());

        // THEN
        then(sprocketResponsePage.getElementCount()).isEqualTo(page.getTotalElements());
        then(sprocketResponsePage.getPageCount()).isEqualTo(page.getTotalPages());
        then(sprocketResponsePage.getPageSize()).isEqualTo(1);
        then(sprocketResponsePage.getPageNumber()).isEqualTo(0);
    }


    @Test
    public void deleteSuccess() {
        // GIVEN - a Sprocket that has already been inserted
        SprocketResponseDTO sprocketInsertResponse = sprocketService.insert(sprocketInsertRequest);

        // set up mock for the delete call
        given(sprocketRepository.findById(any())).willReturn(of(sprocket));

        // WHEN
        SprocketResponseDTO sprocketDeleteResponse = sprocketService.delete(sprocketInsertResponse.getId());

        // THEN
        then(sprocketDeleteResponse.isDeleted()).isTrue();
    }
}
