package org.example.controler;


import lombok.RequiredArgsConstructor;

import org.example.dto.Products;
import org.example.service.ProductService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
@RequiredArgsConstructor


public class ProductController {

    private  final ProductService productService;

    @GetMapping("/filter")
    List<Products> byCatogory(@RequestParam(value = "category",required = false)String category){
        return  productService.byCatogory(category);
    }

    @PostMapping()
    public Products  addProduct(@RequestBody Products product){
        return product;
    }
    @GetMapping()
    List<Products> getAll(){
        return productService.getAll();
    }



}

