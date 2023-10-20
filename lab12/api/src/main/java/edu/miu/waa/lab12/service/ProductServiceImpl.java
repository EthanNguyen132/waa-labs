package edu.miu.waa.lab12.service;

import edu.miu.waa.lab12.model.Product;
import edu.miu.waa.lab12.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository ProductRepository;
    @Override
    public List<Product> findAll() {
        return ProductRepository.findAll();
    }

    @Override
    public Product save(Product Product) {
        return ProductRepository.save(Product);
    }

    @Override
    public void deleteById(int id) {
        ProductRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(int id, Product Product) {
        Product.setId(id);
        return ProductRepository.save(Product);
    }

    @Override
    public Product findById(int id) throws Exception {
        return ProductRepository.findById(id).orElseThrow(Exception::new);
    }
}
