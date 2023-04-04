package com.acme.sprocket.service;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SprocketInsertDTO {
    private String name;
    private int pitchDiameterInches;
    private int outsideDiameterInches;
    private int pitchInches;
}
