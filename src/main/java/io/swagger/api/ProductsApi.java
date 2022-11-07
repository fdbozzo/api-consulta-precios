/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.35).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import org.threeten.bp.OffsetDateTime;
import io.swagger.model.PriceApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-07T10:28:17.635Z[GMT]")
@Validated
public interface ProductsApi {

    @Operation(summary = "Busca un artículo por marca, id prod. y fecha/hora", description = "Permite buscar un artículo indicando el código de marca, el id de artículo y la fecha/hora de consulta", tags={ "Prices" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PriceApiResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid BrandId/ProductId/Datetime value"),
        
        @ApiResponse(responseCode = "404", description = "BrandId/ProductId/Datetime not found"),
        
        @ApiResponse(responseCode = "500", description = "An error occured while processing the request. Please, contact admin@business.com ") })
    @RequestMapping(value = "/products/price",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PriceApiResponse> findByBrandIdProductIdDatetime(@NotNull @Min(1)@Parameter(in = ParameterIn.QUERY, description = "Id de la marca" ,required=true,schema=@Schema(allowableValues={  }, minimum="1"
)) @Valid @RequestParam(value = "brand_id", required = true) Integer brandId, @NotNull @Min(1)@Parameter(in = ParameterIn.QUERY, description = "Id del producto" ,required=true,schema=@Schema(allowableValues={  }, minimum="1"
)) @Valid @RequestParam(value = "product_id", required = true) Integer productId, @NotNull @Parameter(in = ParameterIn.QUERY, description = "Fecha/hora de consulta" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "qry_date", required = true) OffsetDateTime qryDate);

}

