package edu.miu.waa.lab4.model.bi.manytomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Student {

    @Id
    private int id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;
}
