package br.com.integration.sales.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.integration.sales.api.dtos.CreateSaleRequestDTO;
import br.com.integration.sales.api.exceptions.SellerNotFoundException;
import br.com.integration.sales.api.models.Sale;
import br.com.integration.sales.api.services.SaleService;

@RestController

public class SaleController {

  @Autowired
  SaleService saleService;

  @PostMapping("/sale")
  public ResponseEntity<Sale> saveSale(@RequestBody CreateSaleRequestDTO sale) throws SellerNotFoundException {
    Sale savedSale = saleService.create(sale);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedSale);
  }

  @GetMapping("/sale")
  public ResponseEntity<List<Sale>> listSales(Sale sale) {
    List<Sale> allSales = saleService.listAllSales();
    return ResponseEntity.status(HttpStatus.OK).body(allSales);
  }

  @GetMapping("/sale/{id}")
  public ResponseEntity<Sale> listById(@PathVariable Long id) {
    Sale sale = saleService.listById(id);
    return ResponseEntity.status(HttpStatus.OK).body(sale);
  }

  // @DeleteMapping("/sale/{id}")
  // @ResponseStatus(HttpStatus.NO_CONTENT)
  // public void deletedSale(@PathVariable Long id) {
  // saleService.deleteById(id);
  // }

}
