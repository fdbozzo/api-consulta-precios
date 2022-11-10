package io.swagger.repository;

import io.swagger.model.Prices;
import io.swagger.model.PricesCompositeKey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.OffsetDateTime;

@Repository
public interface PricesRepository extends JpaRepository<Prices, PricesCompositeKey> {

  /**
   * Devuelve un registro de precio que coincide con los parámetros indicados y prioridad más alta
   * @param brandId     ID de la marca
   * @param productId   ID del producto
   * @param qryDate     Fecha/hora del precio a consultar
   * @return            Lista de precios que coinciden (1 registro)
   */
  @Query("SELECT p FROM Prices p " +
      "WHERE p.pricesCompositeKey.brandId = :brandId " +
      "AND p.pricesCompositeKey.productId = :productId " +
      "AND :qryDate BETWEEN p.pricesCompositeKey.startDate AND p.pricesCompositeKey.endDate " +
      "AND p.pricesCompositeKey.priority = (" +
      "SELECT MAX(p2.pricesCompositeKey.priority) as min_priority FROM Prices p2 " +
      "WHERE p2.pricesCompositeKey.brandId = :brandId " +
      "AND p2.pricesCompositeKey.productId = :productId " +
      "AND :qryDate BETWEEN p2.pricesCompositeKey.startDate AND p2.pricesCompositeKey.endDate)")
  List<Prices> findByBrandIdProductIdDatetimeByMaxPriority(
      @Param("brandId") Integer brandId,
      @Param("productId") Integer productId,
      @Param("qryDate") OffsetDateTime qryDate);

}
