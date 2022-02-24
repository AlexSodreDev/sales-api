package br.com.integration.sales.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.integration.sales.api.dtos.SellerResponseDTO;
import br.com.integration.sales.api.models.Seller;
import br.com.integration.sales.api.repositories.SellerRepository;

@Service
public class SellerService {

  @Autowired
  SellerRepository repository;

  public Seller create(Seller seller) {
    return repository.save(seller);
  }

  public List<SellerResponseDTO> listSellers() {
    List<SellerResponseDTO> sellers = repository.listSellersWithAvgAndSum_Named();
    return sellers;
  }

  public Seller findById(Long id) {
    Seller seller = repository.findById(id).get();
    return seller;
  }

  // public void deleteById(Long id) {
  // repository.findById(id).get();
  // }

}
