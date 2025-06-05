package org.example.service;

import org.example.dto.Products;

import java.util.List;

public interface ProductService {
    List<Products> byCatogory(String category);
//
   void   createProduct(Products product);

    List<Products> getAll();

    List<Products> SearchProduct(Integer id);

    boolean deleteProduct(Integer id);


//    public void createProduct(Integer id,String name, String adress, Double price, String category);

}