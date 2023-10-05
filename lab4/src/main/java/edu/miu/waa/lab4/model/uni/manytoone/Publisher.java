package edu.miu.waa.lab4.model.uni.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Publisher {

    @Id
    private int id;

    private String name;

}
