package com.acme.sprocket.controller;

import com.acme.sprocket.service.SprocketInsertDTO;
import com.acme.sprocket.service.SprocketResponseDTO;
import com.acme.sprocket.service.SprocketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<SprocketResponseDTO> insert (@RequestBody @Valid SprocketInsertDTO sprocketInsertDTO) {
        return new ResponseEntity<>(sprocketService.insert(sprocketInsertDTO), HttpStatus.CREATED);
    }


}
