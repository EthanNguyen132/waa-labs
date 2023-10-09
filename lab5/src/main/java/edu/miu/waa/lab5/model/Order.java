package edu.miu.waa.lab5.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "customer_order")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private LocalDate date;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderlines;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getOrderId() == order.getOrderId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", orderlines=" + orderlines +
                '}';
    }
}
