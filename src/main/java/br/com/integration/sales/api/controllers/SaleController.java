package br.com.integration.sales.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.integration.sales.api.dtos.CreateSaleRequestDTO;
import br.com.integration.sales.api.models.Sale;
import br.com.integration.sales.api.services.SaleService;

@RestController

public class SaleController {

  @Autowired
  SaleService saleService;

  @PostMapping("/sale")
  public ResponseEntity<Sale> saveSale(@RequestBody CreateSaleRequestDTO sale) {
    Sale savedSale = saleService.create(sale);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedSale);
  }

}
