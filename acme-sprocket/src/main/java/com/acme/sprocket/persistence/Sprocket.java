package com.acme.sprocket.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "sprocket")
public class Sprocket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pitch_diameter_inches", nullable = false)
    private int pitchDiameterInches;

    @Column(name = "outside_diameter_inches", nullable = false)
    private int outsideDiameterInches;

    @Column(name = "pitch_inches", nullable = false)
    private int pitchInches;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;



    public Sprocket() {}

    public Sprocket(UUID id, String name, int pitchDiameterInches, int outsideDiameterInches, int pitchInches) {
        this.id = id;
        this.name = name;
        this.pitchDiameterInches = pitchDiameterInches;
        this.outsideDiameterInches = outsideDiameterInches;
        this.pitchInches = pitchInches;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPitchDiameterInches() {
        return pitchDiameterInches;
    }

    public void setPitchDiameterInches(int pitchDiameterInches) {
        this.pitchDiameterInches = pitchDiameterInches;
    }

    public int getOutsideDiameterInches() {
        return outsideDiameterInches;
    }

    public void setOutsideDiameterInches(int outsideDiameterInches) {
        this.outsideDiameterInches = outsideDiameterInches;
    }

    public int getPitchInches() {
        return pitchInches;
    }

    public void setPitchInches(int pitchInches) {
        this.pitchInches = pitchInches;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Sprocket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pitchDiameterInches=" + pitchDiameterInches +
                ", outsideDiameterInches=" + outsideDiameterInches +
                ", pitchInches=" + pitchInches +
                ", deleted=" + deleted +
                '}';
    }
}
