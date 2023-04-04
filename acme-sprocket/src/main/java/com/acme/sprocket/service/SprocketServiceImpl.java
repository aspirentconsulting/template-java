package com.acme.sprocket.service;

import com.acme.sprocket.common.data.Page;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;
import static org.slf4j.LoggerFactory.getLogger;

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
                sprocketInsertDTO.getPitchInches());
    }

    @Override
    public SprocketResponseDTO findOne(final UUID id) {
        // TODO: implement repository logic
        // for now, echo back the id
        return new SprocketResponseDTO(id, "Spacely", 5, 7, 3 );
    }

    @Override
    public SprocketResponseDTO update(UUID id, SprocketUpdateDTO sprocketUpdateDTO) {
        return null;
    }

    @Override
    public SprocketResponseDTO delete(UUID id) {
        return null;
    }

    @Override
    public Page<SprocketResponseDTO> findAll(SprocketFindAllRequest sprocketFindAllRequest) {
        return null;
    }
}
