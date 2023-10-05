package edu.miu.waa.lab4.model.bi.onetomany;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    private int id;
    private String name;

    @ManyToOne
    private Department department;
}
