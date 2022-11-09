package io.swagger.repository;

import io.swagger.model.Prices;
import io.swagger.model.PricesCompositeKey;
import java.time.OffsetDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Prices, PricesCompositeKey> {

  @Query("SELECT p FROM Prices p WHERE p.brandId = :brandId AND p.productId = :productId AND :qryDate BETWEEN p.startDate AND p.endDate")
  Prices findByBrandIdProductIdDatetime(
      @Param("brandId") Integer brandId,
      @Param("productId") Integer productId,
      @Param("qryDate") OffsetDateTime qryDate);

}
