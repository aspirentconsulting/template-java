package com.acme.sprocket.controller;

import com.acme.sprocket.common.data.Page;
import com.acme.sprocket.service.SprocketFindAllRequest;
import com.acme.sprocket.service.SprocketInsertDTO;
import com.acme.sprocket.service.SprocketResponseDTO;
import com.acme.sprocket.service.SprocketService;
import com.acme.sprocket.service.SprocketUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/inventory")
public class SprocketController {
    private final SprocketService sprocketService;

    @Autowired
    public SprocketController(SprocketService sprocketService) {
        this.sprocketService = sprocketService;
    }

    @GetMapping("helloSprocket")
    public String getSprocket() {
        return "HELLO SPROCKET";
    }

    @GetMapping("sprocket/id/{id}")
    public ResponseEntity<SprocketResponseDTO> findOneById(@PathVariable UUID id) {
        return new ResponseEntity<>(sprocketService.findOne(id), HttpStatus.OK);
    }

    @PostMapping("sprocket")
    public ResponseEntity<SprocketResponseDTO> insertSprocket(@RequestBody @Valid SprocketInsertDTO sprocketInsertDTO) {
        return new ResponseEntity<>(sprocketService.insert(sprocketInsertDTO), HttpStatus.CREATED);
    }

    @PutMapping("sprocket/{id}")
    public ResponseEntity<SprocketResponseDTO> updateSprocket(@RequestBody @Valid SprocketUpdateDTO sprocketUpdateDTO,
                                                              @PathVariable UUID id) {
        return new ResponseEntity<>(sprocketService.update(id, sprocketUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("sprocket/{id}")
    public ResponseEntity<SprocketResponseDTO> deleteSprocket(@PathVariable UUID id) {
        return new ResponseEntity<>(sprocketService.delete(id), HttpStatus.OK);
    }

    @GetMapping("sprockets")
    public Page<SprocketResponseDTO> findAll(final SprocketFindAllRequest sprocketFindAllRequest) {
        return sprocketService.findAll(sprocketFindAllRequest);
    }
}
