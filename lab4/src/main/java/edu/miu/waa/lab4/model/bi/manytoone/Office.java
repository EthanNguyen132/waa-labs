package edu.miu.waa.lab4.model.bi.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "office2")
public class Office {

    @Id
    private int id;
    private String buildingName;
    private String floor;

    @OneToMany(mappedBy = "office")
    private List<Employee> employees;
}
