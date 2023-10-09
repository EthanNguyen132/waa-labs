package edu.miu.waa.lab5.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@DiscriminatorValue("cd")
public class CD extends Product {
    private String artist;
}
