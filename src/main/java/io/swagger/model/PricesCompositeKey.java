package io.swagger.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Embeddable
public class PricesCompositeKey implements Serializable {

  @NotNull
  private Integer brandId;
  //private Brands brands;
  @NotNull
  private Integer productId;
  @NotNull
  private OffsetDateTime startDate = null;
  @NotNull
  private OffsetDateTime endDate = null;
  @NotNull
  private Integer priority;

//  public PricesCompositeKey(Integer brandId, Integer productId, OffsetDateTime startDate, OffsetDateTime endDate, Integer priority) {
//    this.brandId = brandId;
//    this.productId = productId;
//    this.startDate = startDate;
//    this.endDate = endDate;
//    this.priority = priority;
//  }

  private PricesCompositeKey() {
  }

  @Override
  public boolean equals(Object o) {
    if ( this == o ) {
      return true;
    }
    if ( o == null || getClass() != o.getClass() ) {
      return false;
    }
    PricesCompositeKey pricesCompositeKey = (PricesCompositeKey) o;
    return Objects.equals( brandId, pricesCompositeKey.brandId ) &&
        Objects.equals( productId, pricesCompositeKey.productId ) &&
        Objects.equals( startDate, pricesCompositeKey.startDate ) &&
        Objects.equals( endDate, pricesCompositeKey.endDate ) &&
        Objects.equals( priority, pricesCompositeKey.priority );
  }

  @Override
  public int hashCode() {
    return Objects.hash( brandId, productId, startDate, endDate, priority );
  }
}
