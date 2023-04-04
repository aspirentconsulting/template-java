package com.acme.sprocket.service;

import com.acme.sprocket.common.data.Page;

import java.util.UUID;

public interface SprocketService {
    SprocketResponseDTO insert(final SprocketInsertDTO sprocketInsertDTO);
    SprocketResponseDTO update(final UUID id, final SprocketUpdateDTO sprocketUpdateDTO);
    SprocketResponseDTO delete(final UUID id);
    SprocketResponseDTO findOne(final UUID id);
    Page<SprocketResponseDTO> findAll(final SprocketFindAllRequest sprocketFindAllRequest);

}
