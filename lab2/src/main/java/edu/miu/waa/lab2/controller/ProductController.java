package edu.miu.waa.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String products() {
        return "products";
    }

    @GetMapping("/getProduct")
    public String getProductByIdParam(@RequestParam(value = "productId", required = false) String id, Model model) {
        model.addAttribute("productId", id);
        model.addAttribute("title", "product from /getProduct with @RequestParam");
        return "productDetails";
    }

    @GetMapping("/product/{productId}")
    public String getProductByIdPathVar(@PathVariable("productId") String id, Model model) {
        model.addAttribute("productId", id);
        model.addAttribute("title", "product from /product/{productId} with @PathVariable");
        return "productDetails";
    }
}
