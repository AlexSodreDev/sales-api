package br.com.integration.sales.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.integration.sales.api.models.Seller;
import br.com.integration.sales.api.repositories.SellerRepository;

@Service
public class SellerService {

  @Autowired
  SellerRepository repository;

  public Seller create(Seller seller) {
    return repository.save(seller);
  }

}