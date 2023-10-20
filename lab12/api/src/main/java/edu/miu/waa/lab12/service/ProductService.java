package edu.miu.waa.lab12.service;

import edu.miu.waa.lab12.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(int id) throws Exception;

    Product save(Product product);

    void deleteById(int id);

    Product updateProduct(int id, Product product);


}
