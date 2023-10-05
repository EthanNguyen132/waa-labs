package edu.miu.waa.lab4.model.bi.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "employee2")
public class Employee {
    @Id
    private int id;
    private String name;

    @ManyToOne
//    @JoinColumn(name = "office_id")
    private Office office;
}

