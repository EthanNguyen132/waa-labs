package edu.miu.waa.lab4.model.uni.manytoone2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="book2")
public class Book {

    @Id
    private int id;
    private String title;

}
