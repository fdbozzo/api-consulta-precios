package io.swagger.repository;

import io.swagger.model.Prices;
import io.swagger.model.PricesCompositeKey;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Prices, PricesCompositeKey> {

  @Query("SELECT p FROM Prices p WHERE p.pricesCompositeKey.brandId = :brandId AND p.pricesCompositeKey.productId = :productId AND :qryDate BETWEEN p.pricesCompositeKey.startDate AND p.pricesCompositeKey.endDate")
  List<Prices> findByBrandIdProductIdDatetime(
      @Param("brandId") Integer brandId,
      @Param("productId") Integer productId,
      @Param("qryDate") OffsetDateTime qryDate);

  //List<Prices> findAllByBrandIdAndProductIdAndDatetime
}
