package com.acme.sprocket.service;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SprocketUpdateDTO {
    // TODO: eventually, move the id field out into a generic wrapper class
    @NotBlank(message = "Id is mandatory")
    private UUID id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private int pitchDiameterInches;
    private int outsideDiameterInches;
    private int pitchInches;

    private boolean deleted = false;

    public SprocketUpdateDTO() {}

    public SprocketUpdateDTO(UUID id, String name, int pitchDiameterInches, int outsideDiameterInches, int pitchInches) {
        this.id = id;
        this.name = name;
        this.pitchDiameterInches = pitchDiameterInches;
        this.outsideDiameterInches = outsideDiameterInches;
        this.pitchInches = pitchInches;
    }
}
