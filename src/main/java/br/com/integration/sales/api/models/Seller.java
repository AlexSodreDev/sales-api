package br.com.integration.sales.api.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.integration.sales.api.dtos.SellerResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "Seller.listSellersWithAvgAndSum_Named", query = "SELECT S.SELLER_NAME AS name,           (          SELECT          SUM(SALE_VALUE)          FROM SALE SA            WHERE SA.SELLER_ID = S.ID            GROUP BY SALED_AT,                      SELLER_ID                      FETCH FIRST 1 ROW ONLY ) AS averageDailySales,         (SELECT SUM(SALE_VALUE) FROM SALE WHERE SELLER_ID = S.ID)  as totalSalesAmount    FROM SELLER AS S", resultSetMapping = "Mapping.SellerResponseDTO")

@SqlResultSetMapping(name = "Mapping.SellerResponseDTO", classes = @ConstructorResult(targetClass = SellerResponseDTO.class, columns = {
    @ColumnResult(name = "name"),
    @ColumnResult(name = "averageDailySales"),
    @ColumnResult(name = "totalSalesAmount"),
}))

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "SELLER")
public class Seller implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @NotBlank
  @Column(name = "SELLER_NAME")
  private String name;

  @JsonIgnore
  @OneToMany
  private List<Sale> sale;
}
