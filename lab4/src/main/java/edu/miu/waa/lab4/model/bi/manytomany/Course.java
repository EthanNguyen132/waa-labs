package edu.miu.waa.lab4.model.bi.manytomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Course {

    @Id
    private int id;

    private String name;

    @ManyToMany
    private List<Student> students;
}
