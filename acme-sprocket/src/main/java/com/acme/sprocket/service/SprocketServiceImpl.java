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
        //TODO: implement ExceptionHandler
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

//        return new SprocketResponseDTO(
//                UUID.randomUUID(),
//                sprocketInsertDTO.getName(),
//                sprocketInsertDTO.getPitchDiameterInches(),
//                sprocketInsertDTO.getOutsideDiameterInches(),
//                sprocketInsertDTO.getPitchInches(),
//                false);
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
