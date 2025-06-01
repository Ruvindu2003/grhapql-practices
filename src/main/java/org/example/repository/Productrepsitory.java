package org.example.repository;


import org.example.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;



public interface Productrepsitory extends CrudRepository<ProductEntity ,Integer> {

}
