package com.meynier.spring.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Family implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @NotBlank
    public String name;
    @NotNull
    @Column(name = "WATER_TYPE")
    public WaterType waterType;
    @JsonIgnore
    @OneToMany(mappedBy = "family")
    public Collection<Fish> fishs;

    public Family() {
    }

    public Family(long id, @NotBlank String name, @NotNull WaterType waterType) {
        this.id = id;
        this.name = name;
        this.waterType = waterType;
    }

    public Family(long id, @NotBlank String name, @NotNull WaterType waterType, Collection<Fish> fishs) {
        this.id = id;
        this.name = name;
        this.waterType = waterType;
        this.fishs = fishs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WaterType getWaterType() {
        return waterType;
    }

    public void setWaterType(WaterType waterType) {
        this.waterType = waterType;
    }

    public Collection<Fish> getFishs() {
        return fishs;
    }

    public void setFishs(Collection<Fish> fishs) {
        this.fishs = fishs;
    }
}
