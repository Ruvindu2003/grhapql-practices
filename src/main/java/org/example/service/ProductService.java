package org.example.service;

import org.example.dto.Products;

import java.util.List;

public interface ProductService {
    List<Products> byCatogory(String category);

//    Products  createProduct(Products product);

    List<Products> getAll();

    public Products createProduct(String name, String adress, Float price, String category);

}