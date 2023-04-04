package com.acme.sprocket.service;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SprocketResponseDTO {
    private UUID id;
    private String name;
    private int pitchDiameterInches;
    private int outsideDiameterInches;
    private int pitchInches;
}
