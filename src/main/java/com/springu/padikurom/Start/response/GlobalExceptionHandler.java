package com.springu.padikurom.Start.response;
import  com.springu.padikurom.Start.model.ErrorResponse;
import org.springframework.http.HttpStatus;
//import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value= OutOfStockException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse errorResponseChecker(OutOfStockException ex)
    {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value() , ex.getMessage());
    }

    @ExceptionHandler(value= ProductExistsAlready.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse errorResponseChecker(ProductExistsAlready ex)
    {
        return new ErrorResponse(HttpStatus.CONFLICT.value() , ex.getMessage());
    }


}
