package io.swagger.model;

import static org.hibernate.id.PersistentIdentifierGenerator.PK;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@IdClass(PricesCompositeKey.class)
public class Prices {

  // PK
  @Id
  @Column(nullable = false)
  private Integer brandId;

  @Id
  @Column(nullable = false)
  private Integer productId;

  @Id
  @Column(nullable = false)
  private OffsetDateTime startDate = null;

  @Id
  @Column(nullable = false)
  private OffsetDateTime endDate = null;

  @Id
  @Column(nullable = false)
  private Integer priority;
  // end PK

  @Column(nullable = false)
  private Double price;

  @Column(nullable = false)
  private Integer priceList;

  @NotBlank(message="Currency must not be blank. ie: EUR")
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private CurrencyType curr;


  //private OffsetDateTime rqyDate = null;

  public PricesCompositeKey getId() {
    return new PricesCompositeKey(
        brandId,
        productId,
        startDate,
        endDate,
        priority
    );
  }

  public void setId(PricesCompositeKey id) {
    this.brandId = id.getBrandId();
    this.productId = id.getProductId();
    this.startDate = id.getStartDate();
    this.endDate = id.getEndDate();
    this.priority = id.getPriority();
  }

  public enum CurrencyType {
    EUR, USD, GBP
  }

}
