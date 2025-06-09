package org.example.controler;
import lombok.RequiredArgsConstructor;
import org.example.dto.Products;
import org.example.service.ProductService;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
@RequiredArgsConstructor


public class ProductGrhapaController {
    private  final ProductService productService;
    @QueryMapping
    List<Products> getAllProduct(){
        return  productService.getAll();
    }

    @MutationMapping
    public void createProduct(@Argument("input")  Products products){
         productService.createProduct(products);
    }
//    @MutationMapping
//    public void createProduct(@Argument Integer id,@Argument String name, @Argument String adress, @Argument Double price, @Argument String category){
//        productService.createProduct(id,name,adress,price,category);
//
//    }
    @QueryMapping
    public List<Products> SearchProduct(@Argument Integer id){
        return productService.SearchProduct(id);
//        return   new Products(1,"ruvindu","nuwaraEliaya",700.00,"6000erge");
    }

    @QueryMapping
    public void deleteProduct(@Argument Integer id){
        productService.deleteProduct(id);


    }







    }

















