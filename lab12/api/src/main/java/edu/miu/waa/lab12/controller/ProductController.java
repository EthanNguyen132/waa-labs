package edu.miu.waa.lab12.controller;

import edu.miu.waa.lab12.model.Product;
import edu.miu.waa.lab12.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) throws Exception {
        return productService.findById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable int id) throws Exception {
        productService.deleteById(id);
    }


}
