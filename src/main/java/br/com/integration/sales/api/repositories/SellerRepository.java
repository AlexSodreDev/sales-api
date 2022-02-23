package br.com.integration.sales.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.integration.sales.api.dtos.SellerResponseDTO;
import br.com.integration.sales.api.models.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

  @Query(nativeQuery = true)
  List<SellerResponseDTO> listSellersWithAvgAndSum_Named();

}