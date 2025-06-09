package org.example.exseption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobaleExseption {
    @ExceptionHandler(ProductNotFound.class)
    ErrorRespnse hadaleProductNotFound(ProductNotFound ex){
        ErrorRespnse errorRespnse=new ErrorRespnse();
        errorRespnse.setMassage(ex.getMessage());
        new ResponseEntity<>(errorRespnse, HttpStatus.OK);
        return  errorRespnse;



    }
}
