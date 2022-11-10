package io.swagger.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//@IdClass(PricesCompositeKey.class)
@Entity
@Table(name = "prices")
//    uniqueConstraints = @UniqueConstraint(columnNames = {"brand_id", "product_id", "start_date", "end_date", "priority" }))
public class Prices implements Serializable {

  // PK
  @Embedded
  @Id
  //@Column(nullable = false)
  //@ManyToOne(fetch = FetchType.LAZY)
  //@JoinColumn(name = "brand_id")
  //@MapsId
  private PricesCompositeKey pricesCompositeKey;

//  @Id
//  //private Integer brandId;
//  private Brands brands;
//
//  @Id
//  @Column(nullable = false)
//  private Integer productId;
//
//  @Id
//  @Column(nullable = false)
//  private OffsetDateTime startDate = null;
//
//  @Id
//  @Column(nullable = false)
//  private OffsetDateTime endDate = null;
//
//  @Id
//  @Column(nullable = false)
//  private Integer priority;
  // end PK

  @Column(nullable = false)
  private Double price;

  @Column(nullable = false)
  private Integer priceList;

  @NotBlank(message="Currency must not be blank. ie: EUR")
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private CurrencyType curr;

  public int getBrandId() {return this.pricesCompositeKey.getBrandId();};
  public int getProductId() {return this.pricesCompositeKey.getProductId();};
  public OffsetDateTime getStartDate() {return this.pricesCompositeKey.getStartDate();};
  public OffsetDateTime getEndDate() {return this.pricesCompositeKey.getEndDate();};
  public int getPriority() {return this.pricesCompositeKey.getPriority();};

  //private OffsetDateTime rqyDate = null;

  public PricesCompositeKey getId() {
    return new PricesCompositeKey(
        pricesCompositeKey.getBrandId(),
        pricesCompositeKey.getProductId(),
        pricesCompositeKey.getStartDate(),
        pricesCompositeKey.getEndDate(),
        pricesCompositeKey.getPriority()
    );
  }

  public void setId(PricesCompositeKey id) {
    this.pricesCompositeKey.setBrandId(id.getBrandId());
    this.pricesCompositeKey.setProductId(id.getProductId());
    this.pricesCompositeKey.setStartDate(id.getStartDate());
    this.pricesCompositeKey.setEndDate(id.getEndDate());
    this.pricesCompositeKey.setPriority(id.getPriority());
  }

  public enum CurrencyType {
    EUR, USD, GBP
  }

}
