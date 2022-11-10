/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.35).
 * https://github.com/swagger-api/swagger-codegen Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.PriceApiResponse;
import io.swagger.model.PriceApiResponseInner;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.web.context.request.NativeWebRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-07T10:28:17.635Z[GMT]")
@Validated
@RequestMapping("/api/v3")
public interface ProductsApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }


  /**
   * GET /products/price : Busca un artículo por marca, id prod. y fecha/hora
   * Permite buscar un artículo indicando el código de marca, el id de artículo y la fecha/hora de consulta
   *
   * @param brandId Id de la marca (required)
   * @param productId Id del producto (required)
   * @param qryDate Fecha/hora de consulta (required)
   * @return successful operation (status code 200)
   *         or Invalid BrandId/ProductId/Datetime value (status code 400)
   *         or BrandId/ProductId/Datetime not found (status code 404)
   *         or An error occured while processing the request. Please, contact admin@business.com  (status code 500)
   */
  @Operation(
      operationId = "findByBrandIdProductIdDatetime",
      summary = "Busca un artículo por marca, id prod. y fecha/hora",
      tags = { "Prices" },
      responses = {
          @ApiResponse(responseCode = "200", description = "successful operation", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = PriceApiResponseInner.class))
          }),
          @ApiResponse(responseCode = "400", description = "Invalid BrandId/ProductId/Datetime value"),
          @ApiResponse(responseCode = "404", description = "BrandId/ProductId/Datetime not found"),
          @ApiResponse(responseCode = "500", description = "An error occured while processing the request. Please, contact admin@business.com ")
      }
  )

  @RequestMapping(
      value = "/products/price",
      produces = {"application/json"},
      method = RequestMethod.GET)

  default ResponseEntity<List<PriceApiResponseInner>> findByBrandIdProductIdDatetime(
      @NotNull @Min(1) @Parameter(name = "brand_id", description = "Id de la marca", required = true) @Valid @RequestParam(value = "brand_id", required = true) Integer brandId,
      @NotNull @Min(1) @Parameter(name = "product_id", description = "Id del producto", required = true) @Valid @RequestParam(value = "product_id", required = true) Integer productId,
      @NotNull @Parameter(name = "qry_date", description = "Fecha/hora de consulta", required = true) @Valid @RequestParam(value = "qry_date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime qryDate
  ) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "[{ \"end_date\" : \"2000-01-23T04:56:07.000+00:00\", \"price_list\" : 5, \"price\" : 1.4658129805029452, \"product_id\" : 6, \"priority\" : 5, \"curr\" : \"curr\", \"brand_id\" : 0, \"start_date\" : \"2000-01-23T04:56:07.000+00:00\" }]";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

}

