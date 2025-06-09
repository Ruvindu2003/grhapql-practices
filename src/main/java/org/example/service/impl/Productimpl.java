package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.example.dto.Products;
import org.example.entity.ProductEntity;
import org.example.exseption.ProductNotFound;
import org.example.repository.Productrepsitory;
import org.example.service.ProductService;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class Productimpl implements ProductService {


    private final Productrepsitory productrepsitory;
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    @Override
    public List<Products> byCatogory(String category) {

        return null;
    }

    @Override
    public void createProduct(Products product) {
        productrepsitory.save(modelMapper.map(product, ProductEntity.class));

    }

    @Override
    public List<Products> getAll() {


        List<Products> productList = new ArrayList<>();


        List<ProductEntity> productEntities = (List<ProductEntity>) productrepsitory.findAll();
        if (productEntities.isEmpty()) {
            throw new ProductNotFound("Book Not Found");
        }

        if (productEntities.size() > 10) {
            throw new ProductNotFound("Book Not Found");
        }
        productEntities.forEach(ProductEntity -> {
            productList.add(objectMapper.convertValue(ProductEntity, Products.class));
        });
        return productList;
    }

    @Override
    public List<Products> SearchProduct(Integer id) {
        List<Products> products = new ArrayList<>();
        try {
            List<ProductEntity> productEntities = Collections.singletonList(productrepsitory.findById(id).orElse(null));


            productEntities.forEach(productEntity -> {
                products.add(modelMapper.map(productEntity, Products.class));
            });
            return products;
        } catch (Exception e) {
            return List.of();
        }

    }


    @Override
    public boolean deleteProduct(Integer id) {
        if (id.describeConstable().isEmpty()) {
            throw new ProductNotFound("Product Not Found");

        }
            productrepsitory.deleteById(id);


            return true;
        }

    }


//    public void createProduct(Integer id,String name, String adress, Double price, String category) {
//        Products product = new Products();
//        product.setName(name);
//        product.setAdress(adress);
//        product.setPrice(price);
//        product.setCategory(category);
//        modelMapper.map(product,ProductEntity.class);
//
//    }




