package com.acme.sprocket.service;

import com.acme.sprocket.common.data.Page;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import static org.slf4j.LoggerFactory.getLogger;
import static com.acme.sprocket.common.data.request.PageUtility.toPage;
import static java.util.Optional.of;
import static java.util.Arrays.asList;

@Service
public class SprocketServiceImpl implements SprocketService {
    private static final Logger logger = getLogger(SprocketServiceImpl.class);
    @Override
    public SprocketResponseDTO insert(final SprocketInsertDTO sprocketInsertDTO) {
        // TODO: this will be replaced by a call to the SprocketRepository object
        return new SprocketResponseDTO(
                UUID.randomUUID(),
                sprocketInsertDTO.getName(),
                sprocketInsertDTO.getPitchDiameterInches(),
                sprocketInsertDTO.getOutsideDiameterInches(),
                sprocketInsertDTO.getPitchInches(),
                false);
    }

    @Override
    public SprocketResponseDTO findOne(final UUID id) {
        // TODO: implement repository logic
        // for now, echo back the id
        return new SprocketResponseDTO(
                id,
                "Spacely",
                5,
                7,
                3,
                false );
    }

    @Override
    public SprocketResponseDTO update(UUID id, SprocketUpdateDTO sprocketUpdateDTO) {
        // TODO: implement repository logic
        return new SprocketResponseDTO(
                id,
                sprocketUpdateDTO.getName(),
                sprocketUpdateDTO.getPitchDiameterInches(),
                sprocketUpdateDTO.getOutsideDiameterInches(),
                sprocketUpdateDTO.getPitchInches(),
                false);
    }

    @Override
    public SprocketResponseDTO delete(UUID id) {
        // TODO: implement repository logic
        return new SprocketResponseDTO(
                id,
                "Spacely",
                5,
                7,
                3,
                true);
    }

    @Override
    public Page<SprocketResponseDTO> findAll(SprocketFindAllRequest sprocketFindAllRequest) {
        SprocketResponseDTO response1 = new SprocketResponseDTO(
                UUID.randomUUID(),
                "Spacely",
                5,
                7,
                3,
                false);

        SprocketResponseDTO response2 = new SprocketResponseDTO(
                UUID.randomUUID(),
                "Cogswell",
                9,
                11,
                5,
                false);

        return toPage(asList(response1, response2), of(10), of(0));

    }
}
