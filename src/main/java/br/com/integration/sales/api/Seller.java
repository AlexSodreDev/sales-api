package br.com.integration.sales.api;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "SELLER")
public class Seller implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "SELLER_ID")
  private Long id;

  @NonNull
  @Column(name = "SELLER_NAME")
  private String name;

  @NonNull
  @Column(name = "SALES_AMOUNT")
  private String salesAmount;

  @Column(name = "DAILY_SALES_AVERAGE")
  private String dailySalesAverage;

  @ManyToOne
  @JoinColumn(name = "SALE_ID")
  private Sale sale;

}
