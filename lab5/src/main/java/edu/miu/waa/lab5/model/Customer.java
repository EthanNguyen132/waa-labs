package edu.miu.waa.lab5.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;
    private String lastname;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public boolean addOrder(Order o) {
        if (orders.add(o)) {
            o.setCustomer(this);
            return true;
        }
        return false;
    }

    public boolean removeOrder(Order o) {
        if (orders.remove(o)) {
            o.setCustomer(null);
            return true;
        }
        return false;
    }
}
