package com.hominous.familiar.common.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class HelloExceptionControllerAdvice {

  @ExceptionHandler
  public String errorHandler(HelloException e){
    return e.getMessage();
  }
}
