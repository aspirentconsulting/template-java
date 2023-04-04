package com.acme.sprocket.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;
import static org.slf4j.LoggerFactory.getLogger;

@Service
public class SprocketServiceImpl implements SprocketService {
    private static final Logger logger = getLogger(SprocketServiceImpl.class);
    @Override
    public SprocketResponseDTO insert(final SprocketInsertDTO sprocketInsertDTO) {
        return new SprocketResponseDTO(
                UUID.randomUUID(),
                sprocketInsertDTO.getName(),
                sprocketInsertDTO.getPitchDiameterInches(),
                sprocketInsertDTO.getOutsideDiameterInches(),
                sprocketInsertDTO.getPitchInches());
    }

    @Override
    public SprocketResponseDTO findOne(final UUID id) {
        return new SprocketResponseDTO(UUID.randomUUID(), "Spacely", 5, 7, 3 );
    }
}
