package br.com.integration.sales.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SellerController {
  @Autowired
  SellerRepository repository;

  @GetMapping("/hello")
  public void main(String[] args) {
    System.out.println("Hello, World!");
  }

  @PostMapping("/seller")
  public ResponseEntity<Seller> saveSeller(@RequestBody Seller seller) {
    Seller savedSeller = repository.save(seller);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedSeller);
  }
}
