package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.example.dto.Products;
import org.example.entity.ProductEntity;
import org.example.repository.Productrepsitory;
import org.example.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor


public class Productimpl implements ProductService {


    private final Productrepsitory productrepsitory;
    private  final  ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    @Override
    public List<Products> byCatogory(String category) {

        return null;
    }
//
//    @Override
//    public Products  createProduct(Products product) {
//        ProductEntity save = productrepsitory.save(objectMapper.convertValue(product, ProductEntity.class));
//        return  objectMapper.convertValue(save, Products.class);
//    }

    @Override
    public List<Products> getAll() {
        List<Products> productList=new ArrayList<>();
        List<ProductEntity>productEntities= (List<ProductEntity>) productrepsitory.findAll();
        productEntities.forEach(ProductEntity->{
            productList.add(objectMapper.convertValue(ProductEntity, Products.class));
        });
        return productList;
    }

    public Products createProduct(String name, String adress, Float price, String category) {
        Products product = new Products();
        product.setName(name);
        product.setAdress(adress);
        product.setPrice(price);
        product.setCategory(category);
        modelMapper.map(product,ProductEntity.class);
        return product;
    }
}



