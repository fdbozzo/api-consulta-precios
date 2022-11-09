package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * PriceApiResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-07T10:28:17.635Z[GMT]")

public class PriceApiResponse {

  @JsonProperty("brand_id")
  private Integer brandId = null;

  @JsonProperty("start_date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS+00:00")
  private OffsetDateTime startDate = null;

  @JsonProperty("end_date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS+00:00")
  private OffsetDateTime endDate = null;

  @JsonProperty("product_id")
  private Integer productId = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("price_list")
  private Integer priceList = null;

  @JsonProperty("priority")
  private Integer priority = null;

  @JsonProperty("curr")
  private String curr = null;

  public PriceApiResponse brandId(Integer brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * Get brandId
   *
   * @return brandId
   **/
  @Schema(description = "")

  public Integer getBrandId() {
    return brandId;
  }

  public void setBrandId(Integer brandId) {
    this.brandId = brandId;
  }

  public PriceApiResponse startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   *
   * @return startDate
   **/
  @Schema(description = "")

  @Valid
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public PriceApiResponse endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   *
   * @return endDate
   **/
  @Schema(description = "")

  @Valid
  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public PriceApiResponse productId(Integer productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   *
   * @return productId
   **/
  @Schema(description = "")

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public PriceApiResponse price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   *
   * @return price
   **/
  @Schema(description = "")

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public PriceApiResponse priceList(Integer priceList) {
    this.priceList = priceList;
    return this;
  }

  /**
   * Get priceList
   *
   * @return priceList
   **/
  @Schema(description = "")

  public Integer getPriceList() {
    return priceList;
  }

  public void setPriceList(Integer priceList) {
    this.priceList = priceList;
  }

  public PriceApiResponse priority(Integer priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Get priority
   *
   * @return priority
   **/
  @Schema(description = "")

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public PriceApiResponse curr(String curr) {
    this.curr = curr;
    return this;
  }

  /**
   * Get curr
   *
   * @return curr
   **/
  @Schema(description = "")

  public String getCurr() {
    return curr;
  }

  public void setCurr(String curr) {
    this.curr = curr;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceApiResponse priceApiResponse = (PriceApiResponse) o;
    return Objects.equals(this.brandId, priceApiResponse.brandId) &&
        Objects.equals(this.startDate, priceApiResponse.startDate) &&
        Objects.equals(this.endDate, priceApiResponse.endDate) &&
        Objects.equals(this.productId, priceApiResponse.productId) &&
        Objects.equals(this.price, priceApiResponse.price) &&
        Objects.equals(this.priceList, priceApiResponse.priceList) &&
        Objects.equals(this.priority, priceApiResponse.priority) &&
        Objects.equals(this.curr, priceApiResponse.curr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(brandId, startDate, endDate, productId, price, priceList, priority, curr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceApiResponse {\n");

    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceList: ").append(toIndentedString(priceList)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    curr: ").append(toIndentedString(curr)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first
   * line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
