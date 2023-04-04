package com.acme.sprocket.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;
import static org.slf4j.LoggerFactory.getLogger;

@Service
public class SprocketServiceImpl implements SprocketService {
    private static final Logger logger = getLogger(SprocketServiceImpl.class);
    @Override
    public SprocketResponse insert(final SprocketInsertRequest sprocketInsertRequest) {
        return new SprocketResponse(
                UUID.randomUUID(),
                sprocketInsertRequest.getName(),
                sprocketInsertRequest.getPitchDiameterInches(),
                sprocketInsertRequest.getOutsideDiameterInches(),
                sprocketInsertRequest.getPitchInches());
    }

    @Override
    public SprocketResponse findOne(final UUID id) {
        return new SprocketResponse(UUID.randomUUID(), "Spacely", 5, 7, 3 );
    }
}
