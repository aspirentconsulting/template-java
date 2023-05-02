package com.acme.sprocket.service;

import com.acme.sprocket.common.data.page.Page;
import com.acme.sprocket.exception.SprocketNotFoundException;
import com.acme.sprocket.persistence.Sprocket;
import com.acme.sprocket.repository.SprocketRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import static org.slf4j.LoggerFactory.getLogger;
import static com.acme.sprocket.common.data.page.PageUtility.toPage;
import static com.acme.sprocket.common.data.page.PageRequestUtility.pageRequest;

@Service
public class SprocketServiceImpl implements SprocketService {
    private static final Logger logger = getLogger(SprocketServiceImpl.class);

    private SprocketRepository sprocketRepository;

    @Autowired
    public SprocketServiceImpl(SprocketRepository sprocketRepository) {
        this.sprocketRepository = sprocketRepository;
    }

    @Override
    public Page<SprocketResponseDTO> findAll(SprocketFindAllRequest sprocketFindAllRequest) {
        return toPage(sprocketRepository.findAll(pageRequest(
                sprocketFindAllRequest.getPageNumber(),
                sprocketFindAllRequest.getPageSize()))
                .map(this::toSprocketResponseDTO));
    }

    @Override
    public SprocketResponseDTO findOne(final UUID id) {
        return sprocketRepository.findById(id)
                .map(this::toSprocketResponseDTO)
                .orElseThrow(() -> new SprocketNotFoundException(id));
    }

    @Override
    public SprocketResponseDTO insert(final SprocketInsertDTO sprocketInsertDTO) {
        return toSprocketResponseDTO(sprocketRepository.saveAndFlush(
                new Sprocket(
                        sprocketInsertDTO.getName(),
                        sprocketInsertDTO.getPitchDiameterInches(),
                        sprocketInsertDTO.getOutsideDiameterInches(),
                        sprocketInsertDTO.getPitchInches()
                )));
    }

    @Override
    public SprocketResponseDTO update(UUID id, SprocketUpdateDTO sprocketUpdateDTO) {
        return sprocketRepository.findById(id)
                .map(sprocket -> {
                    sprocket.setName(sprocketUpdateDTO.getName());
                    sprocket.setPitchInches(sprocketUpdateDTO.getPitchInches());
                    sprocket.setPitchDiameterInches(sprocketUpdateDTO.getPitchDiameterInches());
                    sprocket.setOutsideDiameterInches(sprocketUpdateDTO.getOutsideDiameterInches());

                    Sprocket updatedSprocket = sprocketRepository.saveAndFlush(sprocket);
                    return toSprocketResponseDTO(updatedSprocket);
                }).orElseThrow(() -> new SprocketNotFoundException(id));
    }

    @Override
    public SprocketResponseDTO delete(UUID id) {
        return sprocketRepository.findById(id)
                .map(sprocketToDelete -> {
                    sprocketToDelete.setDeleted(true);
                    Sprocket updatedSprocket = sprocketRepository.saveAndFlush(sprocketToDelete);
                    return toSprocketResponseDTO(updatedSprocket);
                }).orElseThrow(() -> new SprocketNotFoundException(id));
    }

    private SprocketResponseDTO toSprocketResponseDTO(final Sprocket sprocket) {
        return new SprocketResponseDTO(
                sprocket.getId(),
                sprocket.getName(),
                sprocket.getPitchDiameterInches(),
                sprocket.getOutsideDiameterInches(),
                sprocket.getPitchInches(),
                sprocket.getDeleted());
    }
}
