package edu.miu.waa.lab4.model.bi.onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Department {
    @Id
    private int id;
    private String name;
    private String description;
    private String location;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
