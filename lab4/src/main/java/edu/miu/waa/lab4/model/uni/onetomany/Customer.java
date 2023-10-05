package edu.miu.waa.lab4.model.uni.onetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    private int id;
    private String name;
    private String address;

    @OneToMany
//    @JoinTable(
//            name = "customer_reservations",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "reservations_id")
//    )
    private List<Reservation> reservations;
}
