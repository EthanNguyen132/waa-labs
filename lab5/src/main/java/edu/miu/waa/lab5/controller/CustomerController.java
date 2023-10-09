package edu.miu.waa.lab5.controller;

import edu.miu.waa.lab5.exception.InvalidRecordException;
import edu.miu.waa.lab5.exception.RecordNotFoundException;
import edu.miu.waa.lab5.model.Customer;
import edu.miu.waa.lab5.model.Product;
import edu.miu.waa.lab5.repository.CustomerRepository;
import edu.miu.waa.lab5.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@RequestMapping("customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @PostMapping
    public Customer createCustomerWithOrders(@RequestBody Customer customer) {
        // product is the parent object of orderLine, need to save Product first!
        List<Product> products = Optional.ofNullable(customer)
                .map(c -> c.getOrders())
                .stream()
                .flatMap(orderList -> orderList.stream())
                .flatMap(order -> Stream.ofNullable(order))
                .flatMap(order -> Stream.ofNullable(order.getOrderlines()))
                .flatMap(orderLines -> orderLines.stream())
                .flatMap(orderLine -> Stream.ofNullable(orderLine))
                .map(orderLine -> orderLine.getProduct())
                .flatMap(product -> Stream.ofNullable(product))
                .collect(Collectors.toList());

        products.forEach(product -> {
            try {
                productRepository.save(product);
            } catch (Exception e) {
                throw new InvalidRecordException(e);
            }
        });

        return customerRepository.save(customer);
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new RecordNotFoundException("Customer not " +
                "found"));
    }
}
