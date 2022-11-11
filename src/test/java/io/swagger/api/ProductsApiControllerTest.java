package io.swagger.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.exceptions.ApiException;
import io.swagger.model.PriceApiResponseInner;
import io.swagger.repository.PricesRepository;
import io.swagger.service.ProductsService;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
class ProductsApiControllerTest {

  @LocalServerPort
  private Integer port;

  private ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  private TestRestTemplate restTemplate;;

  @BeforeEach
  void setUp() {

  }

  @Test
  void findByBrandId_1_ProductId_1_Datetime_20201014T000000Z_deberiaDevolver_RecordNotFound() {
    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
    ResponseEntity<String> response =
        restTemplate.exchange("/api/v3/products/price?brand_id=1&product_id=1&qry_date=2020-10-14T00:00:00Z",
        HttpMethod.GET, entity, String.class);
    System.out.println("response:\n" + response.getBody());
    assertNotNull(response.getBody());
    ApiException apiException = new ApiException(HttpStatus.NOT_FOUND.value(), "BrandId/ProductId/Datetime not found");
    try {
      //System.out.println("expected:\n" + objectMapper.writeValueAsString(apiException));
      assertEquals(objectMapper.writeValueAsString(apiException), response.getBody());
    } catch (JsonProcessingException e) {
      System.out.println(e.getMessage());;
    }
  }

  @Test
  void test_1_findByBrandId_1_ProductId_35455_Datetime_20200614T100000Z_deberiaDevolver_Price_35_50() {
    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
    ResponseEntity<String> response =
        restTemplate.exchange("/api/v3/products/price?brand_id=1&product_id=35455&qry_date=2020-06-14T10:00:00Z",
        HttpMethod.GET, entity, String.class);
    System.out.println("response:\n" + response.getBody());
    assertNotNull(response.getBody());
    PriceApiResponseInner priceApiResponseInner = new PriceApiResponseInner()
        .brandId(1)
        .startDate(OffsetDateTime.parse("2020-06-14T00:00:00Z"))
        .endDate(OffsetDateTime.parse("2020-12-31T23:59:59Z"))
        .productId(35455)
        .price(35.50)
        .priceList(1)
        .priority(0)
        .curr("EUR");
    String expected = "[" + getJsonFromPriceApiResponseInner(priceApiResponseInner) + "]";
    //System.out.println("expected:\n" + expected);
    assertEquals(expected, response.getBody());
  }

  @Test
  void test_2_findByBrandId_1_ProductId_35455_Datetime_20200614T160000Z_deberiaDevolver_Price_35_50() {
    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
    ResponseEntity<String> response =
        restTemplate.exchange("/api/v3/products/price?brand_id=1&product_id=35455&qry_date=2020-06-14T16:00:00Z",
            HttpMethod.GET, entity, String.class);
    System.out.println("response:\n" + response.getBody());
    assertNotNull(response.getBody());
    PriceApiResponseInner priceApiResponseInner = new PriceApiResponseInner()
        .brandId(1)
        .startDate(OffsetDateTime.parse("2020-06-14T00:00:00Z"))
        .endDate(OffsetDateTime.parse("2020-12-31T23:59:59Z"))
        .productId(35455)
        .price(35.50)
        .priceList(1)
        .priority(0)
        .curr("EUR");
    String expected = "[" + getJsonFromPriceApiResponseInner(priceApiResponseInner) + "]";
    //System.out.println("expected:\n" + expected);
    assertEquals(expected, response.getBody());
  }

  @Test
  void test_3_findByBrandId_1_ProductId_35455_Datetime_20200614T210000Z_deberiaDevolver_Price_35_50() {
    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
    ResponseEntity<String> response =
        restTemplate.exchange("/api/v3/products/price?brand_id=1&product_id=35455&qry_date=2020-06-14T21:00:00Z",
            HttpMethod.GET, entity, String.class);
    System.out.println("response:\n" + response.getBody());
    assertNotNull(response.getBody());
    PriceApiResponseInner priceApiResponseInner = new PriceApiResponseInner()
        .brandId(1)
        .startDate(OffsetDateTime.parse("2020-06-14T00:00:00Z"))
        .endDate(OffsetDateTime.parse("2020-12-31T23:59:59Z"))
        .productId(35455)
        .price(35.50)
        .priceList(1)
        .priority(0)
        .curr("EUR");
    String expected = "[" + getJsonFromPriceApiResponseInner(priceApiResponseInner) + "]";
    //System.out.println("expected:\n" + expected);
    assertEquals(expected, response.getBody());
  }

  @Test
  void test_4_findByBrandId_1_ProductId_35455_Datetime_20200615T100000Z_deberiaDevolver_Price_30_50() {
    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
    ResponseEntity<String> response =
        restTemplate.exchange("/api/v3/products/price?brand_id=1&product_id=35455&qry_date=2020-06-15T10:00:00Z",
            HttpMethod.GET, entity, String.class);
    System.out.println("response:\n" + response.getBody());
    assertNotNull(response.getBody());
    PriceApiResponseInner priceApiResponseInner = new PriceApiResponseInner()
        .brandId(1)
        .startDate(OffsetDateTime.parse("2020-06-15T00:00:00Z"))
        .endDate(OffsetDateTime.parse("2020-06-15T11:00:00Z"))
        .productId(35455)
        .price(30.50)
        .priceList(3)
        .priority(1)
        .curr("EUR");
    String expected = "[" + getJsonFromPriceApiResponseInner(priceApiResponseInner) + "]";
    //System.out.println("expected:\n" + expected);
    assertEquals(expected, response.getBody());
  }

  @Test
  void test_5_findByBrandId_1_ProductId_35455_Datetime_20200616T210000Z_deberiaDevolver_Price_38_95() {
    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
    ResponseEntity<String> response =
        restTemplate.exchange("/api/v3/products/price?brand_id=1&product_id=35455&qry_date=2020-06-16T21:00:00Z",
            HttpMethod.GET, entity, String.class);
    System.out.println("response:\n" + response.getBody());
    assertNotNull(response.getBody());
    PriceApiResponseInner priceApiResponseInner = new PriceApiResponseInner()
        .brandId(1)
        .startDate(OffsetDateTime.parse("2020-06-15T16:00:00Z"))
        .endDate(OffsetDateTime.parse("2020-12-31T23:59:59Z"))
        .productId(35455)
        .price(38.95)
        .priceList(4)
        .priority(1)
        .curr("EUR");
    String expected = "[" + getJsonFromPriceApiResponseInner(priceApiResponseInner) + "]";
    //System.out.println("expected:\n" + expected);
    assertEquals(expected, response.getBody());
  }


  // UTILITY METHODS
  private String getJsonFromPriceApiResponseInner(PriceApiResponseInner priceApiResponseInner) {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    return "{\"brand_id\":" + priceApiResponseInner.getBrandId().toString() +
        ",\"start_date\":\"" + formatter.format(priceApiResponseInner.getStartDate()) + "\"" +
        ",\"end_date\":\"" + formatter.format(priceApiResponseInner.getEndDate()) + "\"" +
        ",\"product_id\":" + priceApiResponseInner.getProductId().toString() +
        ",\"price\":" + priceApiResponseInner.getPrice().toString() +
        ",\"price_list\":" + priceApiResponseInner.getPriceList().toString() +
        ",\"priority\":" + priceApiResponseInner.getPriority().toString() +
        ",\"curr\":\"" + priceApiResponseInner.getCurr() + "\"" +
        "}";
  }

}