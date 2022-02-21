package br.com.integration.sales.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class SellerController {
  @Autowired
  SellerRepository repository;

  @GetMapping("/hello")
  public void main(String[] args) {
    System.out.println("Hello, World!");
  }

}
