package com.hominous.familiar.common.exception;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloExceptionController {

  @GetMapping("/exception/{message}")
  public String makeException(@PathVariable String message){
    throw new HelloException(message);
  }
}
