package io.swagger.service;

import io.swagger.exceptions.NotFoundException;
import io.swagger.model.Prices;
import io.swagger.repository.PricesRepository;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;

@Slf4j
@Service
public class ProductsService {

  @Autowired
  PricesRepository pricesRepository;

  public List<Prices> findByBrandIdProductIdDatetime(
      Integer brandId,
      Integer productId,
      OffsetDateTime qryDate) throws IOException {

    List<Prices> prices = pricesRepository.findByBrandIdProductIdDatetimeByMaxPriority(brandId, productId, qryDate);

    if (prices == null || prices.size() == 0) {
      throw new NotFoundException(HttpStatus.NOT_FOUND.value(), "Record not found");
    }

    return prices;
  }

}
