package br.com.integration.sales.api.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.integration.sales.api.dtos.SellerResponseDTO;
import br.com.integration.sales.api.models.Seller;
import br.com.integration.sales.api.repositories.SellerJdbcRepository;
import br.com.integration.sales.api.repositories.SellerRepository;

@Service
public class SellerService {

  @Autowired
  SellerRepository repository;

  @Autowired
  SellerJdbcRepository sellerJdbcRepository;

  public Seller create(Seller seller) {
    return repository.save(seller);
  }

  public List<SellerResponseDTO> listSellers() {
    List<SellerResponseDTO> sellers = repository.listSellersWithAvgAndSum_Named();
    return sellers;
  }

  public List<SellerResponseDTO> listSellers(Date startDate, Date endDate) {
    List<SellerResponseDTO> sellers = sellerJdbcRepository.listSellersWithAvgAndSum(startDate, endDate);
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
