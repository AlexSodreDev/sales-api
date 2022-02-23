package br.com.integration.sales.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerResponseDTO {
  private String name;
  private Double averageDailySales;
  private Double totalSalesAmount;

}
