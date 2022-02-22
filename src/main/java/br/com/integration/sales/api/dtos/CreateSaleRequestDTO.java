package br.com.integration.sales.api.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Getter
@Setter
public class CreateSaleRequestDTO {
  private Long id;
  private LocalDate saledAt;
  private Double saleValue;
  private Long sellerId;
}
