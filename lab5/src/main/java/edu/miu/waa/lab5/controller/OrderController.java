package edu.miu.waa.lab5.controller;

import edu.miu.waa.lab5.exception.RecordNotFoundException;
import edu.miu.waa.lab5.model.Customer;
import edu.miu.waa.lab5.model.Order;
import edu.miu.waa.lab5.model.Product;
import edu.miu.waa.lab5.repository.CustomerRepository;
import edu.miu.waa.lab5.repository.OrderLineRepository;
import edu.miu.waa.lab5.repository.OrderRepository;
import edu.miu.waa.lab5.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderLineRepository orderLineRepository;

    // add order via customerRepository
    @PutMapping("customers/{customer_id}/orders")
    @Transactional
    public ResponseEntity<Customer> addOrderForCustomer(@PathVariable(required = true, value = "customer_id") Integer customerId,
                                                        @RequestBody Order order) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.addOrder(order);

            insertProduct(order);
            return ResponseEntity.ok(customerRepository.save(customer));
        }
        throw new RecordNotFoundException("customer not found");
    }

    // add order via orderRepository
    @PostMapping("customers/{customer_id}/orders")
    @Transactional
    public ResponseEntity<Order> createOrderForCustomer(@PathVariable(required = true, value = "customer_id") Integer customerId,
                                                        @RequestBody Order order) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            order.setCustomer(optionalCustomer.get());

            insertProduct(order);
            return ResponseEntity.ok(orderRepository.save(order));
        }
        throw new RecordNotFoundException("customer not found");
    }

    // delete order via customerRepository
    @DeleteMapping("customers/{customerId}/orders/{orderId}")
    @Transactional
    public ResponseEntity<Customer> deleteOrderByCustomer(@PathVariable Integer customerId,
                                                          @PathVariable Integer orderId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            Order order = orderRepository.findById(orderId).orElseThrow(() -> new RecordNotFoundException("order not " +
                    "found"));
            customer.removeOrder(order);
            return ResponseEntity.ok(customerRepository.save(customer));
        }
        throw new RecordNotFoundException("customer not found");
    }

    // delete order via orderRepository
    @DeleteMapping("orders/{orderId}")
    @Transactional
    public ResponseEntity<Order> deleteOrderForCustomer(@PathVariable int orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException("order not found"));
        order.setCustomer(null);
        orderRepository.delete(order);
        return ResponseEntity.ok(order);
    }

    private void insertProduct(Order order) {
        List<Product> products = Optional.ofNullable(order)
                .map(c -> c.getOrderlines())
                .stream()
                .flatMap(orderList -> orderList.stream())
                .flatMap(orderLine -> Stream.ofNullable(orderLine))
                .map(orderLine -> orderLine.getProduct())
                .flatMap(product -> Stream.ofNullable(product))
                .collect(Collectors.toList());

        products.forEach(product -> {
            try {
                productRepository.save(product);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
