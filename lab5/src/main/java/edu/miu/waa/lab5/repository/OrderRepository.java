package edu.miu.waa.lab5.repository;

import edu.miu.waa.lab5.model.Customer;
import edu.miu.waa.lab5.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
