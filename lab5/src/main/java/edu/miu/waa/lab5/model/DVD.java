package edu.miu.waa.lab5.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@DiscriminatorValue("dvd")
public class DVD extends Product {
    private String genre;
}
