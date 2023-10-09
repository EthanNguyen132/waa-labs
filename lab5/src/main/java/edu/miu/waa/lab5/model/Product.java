package edu.miu.waa.lab5.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // cannot insert with customer
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name, description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() == product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
