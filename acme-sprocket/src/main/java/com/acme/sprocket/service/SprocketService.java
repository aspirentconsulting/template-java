package com.acme.sprocket.service;

import com.acme.sprocket.common.data.page.Page;

import java.util.UUID;

public interface SprocketService {
    Page<SprocketResponseDTO> findAll(final SprocketFindAllRequest sprocketFindAllRequest);
    SprocketResponseDTO findOne(final UUID id);
    SprocketResponseDTO insert(final SprocketInsertDTO sprocketInsertDTO);
    SprocketResponseDTO update(final UUID id, final SprocketUpdateDTO sprocketUpdateDTO);
    SprocketResponseDTO delete(final UUID id);
}
