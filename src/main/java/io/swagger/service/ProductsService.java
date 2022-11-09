package io.swagger.service;

import io.swagger.model.Prices;
import io.swagger.repository.PricesRepository;
import java.io.IOException;
import java.time.OffsetDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductsService {

  @Autowired
  PricesRepository pricesRepository;

  public Prices findByBrandIdProductIdDatetime(
      Integer brandId,
      Integer productId,
      OffsetDateTime qryDate) throws IOException {

    Prices prices = pricesRepository.findByBrandIdProductIdDatetime(brandId, productId, qryDate);
    return prices;
  }

}