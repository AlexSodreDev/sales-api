package br.com.integration.sales.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.integration.sales.api.models.Seller;
import br.com.integration.sales.api.services.SellerService;

@RestController
public class SellerController {

  @Autowired
  SellerService sellerService;

  @GetMapping("/hello")
  public void main(String[] args) {
    System.out.println("Hello, World!");
  }

  @PostMapping("/seller")
  public ResponseEntity<Seller> saveSeller(@RequestBody Seller seller) {
    Seller savedSeller = sellerService.create(seller);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedSeller);
  }

}
