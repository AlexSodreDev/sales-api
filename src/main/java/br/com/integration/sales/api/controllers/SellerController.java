package br.com.integration.sales.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.integration.sales.api.dtos.SellerResponseDTO;
import br.com.integration.sales.api.models.Seller;
import br.com.integration.sales.api.repositories.SellerRepository;
import br.com.integration.sales.api.services.SellerService;

@RestController
public class SellerController {

  @Autowired
  SellerService sellerService;

  @Autowired
  SellerRepository sellerRepository;

  @GetMapping("/hello")
  public void main(String[] args) {
    System.out.println("Hello, World!");
  }

  @PostMapping("/seller")
  public ResponseEntity<Seller> saveSeller(@RequestBody Seller seller) {
    Seller savedSeller = sellerService.create(seller);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedSeller);
  }

  @GetMapping("/seller")
  public ResponseEntity<List<SellerResponseDTO>> listSellers() {
    List<SellerResponseDTO> sellers = sellerService.listSellers();
    return ResponseEntity.status(HttpStatus.OK).body(sellers);
  }

  @GetMapping("/seller/{id}")
  public ResponseEntity<Seller> listById(@PathVariable Long id) {
    Seller seller = sellerService.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(seller);
  }

  // @DeleteMapping("/seller/{id}")
  // @ResponseStatus(HttpStatus.NO_CONTENT)
  // public void deletedSeller(@PathVariable Long id) {
  // sellerService.deleteById(id);
  // }

}