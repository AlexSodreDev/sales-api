package br.com.integration.sales.api.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.integration.sales.api.dtos.SellerResponseDTO;

@Repository
public class SellerJdbcRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<SellerResponseDTO> listSellersWithAvgAndSum(Date startDate, Date endDate) {
        String query = "  SELECT S.SELLER_NAME AS name, " +
                "  (SELECT SUM(SALE_VALUE) " +
                "  FROM SALE SA " +
                "  WHERE SA.SELLER_ID = S.ID " +
                "    AND SA.SALED_AT >= :startDate   " +
                "  AND SA.SALED_AT <= :endDate   " +
                "  GROUP BY SALED_AT, " +
                "            SELLER_ID FETCH FIRST 1 ROW ONLY) AS averageDailySales, " +
                "  (SELECT SUM(SALE_VALUE) " +
                "  FROM SALE " +
                "  WHERE SELLER_ID = S.ID " +
                "    AND SALED_AT >= :startDate   " +
                "  AND SALED_AT <= :endDate  ) AS totalSalesAmount " +
                " FROM SELLER AS S";

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("startDate", startDate);
        mapSqlParameterSource.addValue("endDate", endDate);
        List<SellerResponseDTO> sellers = namedParameterJdbcTemplate.query(query, mapSqlParameterSource,
                (rs, rowNum) -> new SellerResponseDTO(
                        rs.getString("name"),
                        rs.getDouble("averageDailySales"),
                        rs.getDouble("totalSalesAmount")));
        System.out.println(sellers);
        return sellers;
    }

}