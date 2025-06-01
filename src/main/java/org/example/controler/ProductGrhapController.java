package org.example.controler;


import lombok.RequiredArgsConstructor;

import org.example.dto.Products;
import org.example.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class ProductGrhapController {
    private  final ProductService productService;


    @QueryMapping
    List<Products> getAllProduct(){
        return  productService.getAll();
    }

//    @MutationMapping
//    public Products createProduct( Products product){
//        return productService. createProduct(product);
//    }

    @MutationMapping
    public Products createProduct(@Argument String name, @Argument String adress, @Argument Float price, @Argument String category){
        return productService.createProduct(name,adress,price,category);
    }



}
