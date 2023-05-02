package com.acme.sprocket.exception;

import java.util.UUID;

public class SprocketNotFoundException extends RuntimeException {
    private UUID id;
    private String name;

    public SprocketNotFoundException(UUID id) {
        super("Could not find Sprocket: " + id);
        this.id = id;
    }

    public SprocketNotFoundException(String name) {
        super("Could not find Sprocket named: " + name);
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SprocketNotFoundException{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
