package br.com.integration.sales.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.integration.sales.api.models.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
