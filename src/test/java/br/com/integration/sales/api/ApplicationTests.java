package br.com.integration.sales.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.integration.sales.api.dtos.CreateSaleRequestDTO;
import br.com.integration.sales.api.exceptions.SellerNotFoundException;
import br.com.integration.sales.api.models.Sale;
import br.com.integration.sales.api.models.Seller;
import br.com.integration.sales.api.repositories.SaleRepository;
import br.com.integration.sales.api.repositories.SellerRepository;
import br.com.integration.sales.api.services.SaleService;

@SpringBootTest
class ApplicationTests {

	@Autowired
	SaleRepository saleRepository;

	@Autowired
	SellerRepository sellerRepository;

	@Autowired
	SaleService saleService;

	@Test
	void shouldCreateASaleWhenSellerExists() {
		Seller seller = new Seller();
		seller.setName("name");
		Seller savedSeller = sellerRepository.save(seller);

		assertNotNull(savedSeller);

		CreateSaleRequestDTO createSaleRequestDTO = new CreateSaleRequestDTO();
		createSaleRequestDTO.setSaleValue(Double.parseDouble("20.22"));
		createSaleRequestDTO.setSaledAt(LocalDate.of(2021, 02, 02));
		createSaleRequestDTO.setSellerId(savedSeller.getId());

		try {
			Sale savedSale = saleService.create(createSaleRequestDTO);
			assertNotNull(savedSale.getId());
		} catch (SellerNotFoundException e) {
			e.printStackTrace();
		}
	}

}
