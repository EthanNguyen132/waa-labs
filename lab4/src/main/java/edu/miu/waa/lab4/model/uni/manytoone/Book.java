package edu.miu.waa.lab4.model.uni.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    private int id;

    private String title;

    @ManyToOne
//    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
