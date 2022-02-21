package br.com.integration.sales.api;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "SALE_ID")
  private Long id;

  @Column(name = "SALED_AT")
  private Timestamp saledAt;

  @Column(name = "VALUE")
  private Integer value;

  @JoinColumn(name = "SELLER_ID")
  private String sellerId;

  @OneToMany(mappedBy = "sale", targetEntity = Seller.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Seller> sellers;
}