package br.com.integration.sales.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.integration.sales.api.models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
