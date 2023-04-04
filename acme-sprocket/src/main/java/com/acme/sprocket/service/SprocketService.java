package com.acme.sprocket.service;

import java.util.UUID;

public interface SprocketService {
    SprocketResponseDTO insert(final SprocketInsertDTO sprocketInsertDTO);
    SprocketResponseDTO findOne(final UUID id);
}
