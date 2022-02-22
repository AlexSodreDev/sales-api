package br.com.integration.sales.api.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SALE")
public class Sale implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "SALED_AT")
  private LocalDate saledAt;

  @JoinColumn(name = "SALE_VALUE")
  private Double saleValue;

  @ManyToOne
  @JoinColumn(name = "SELLER_ID")
  private Seller sellers;

}