package com.acme.sprocket.service;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SprocketInsertDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;
    private int pitchDiameterInches;
    private int outsideDiameterInches;
    private int pitchInches;
}
