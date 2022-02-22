package br.com.integration.sales.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.integration.sales.api.dtos.CreateSaleRequestDTO;
import br.com.integration.sales.api.exceptions.SellerNotFoundException;
import br.com.integration.sales.api.models.Sale;
import br.com.integration.sales.api.models.Seller;
import br.com.integration.sales.api.repositories.SaleRepository;
import br.com.integration.sales.api.repositories.SellerRepository;

@Service
public class SaleService {

  @Autowired
  SaleRepository saleRepository;

  @Autowired
  SellerRepository sellerRepository;

  public Sale create(CreateSaleRequestDTO sale) throws SellerNotFoundException {
    Optional<Seller> existingSeller = sellerRepository.findById(sale.getSellerId());
    if (!existingSeller.isPresent()) {
      throw new SellerNotFoundException();
    }

    return saleRepository.save(new Sale(sale.getId(), sale.getSaledAt(), sale.getSaleValue(), existingSeller.get()));
  }
}
