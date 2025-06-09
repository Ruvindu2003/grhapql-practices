package org.example.exseption;

public class ProductNotFound extends RuntimeException{

    public ProductNotFound (String massage){
        super(massage);
    }
}
