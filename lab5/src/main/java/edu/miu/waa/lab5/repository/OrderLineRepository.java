package edu.miu.waa.lab5.repository;

import edu.miu.waa.lab5.model.Customer;
import edu.miu.waa.lab5.model.Order;
import edu.miu.waa.lab5.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

}
