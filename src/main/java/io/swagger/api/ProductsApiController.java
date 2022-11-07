package io.swagger.api;

import org.threeten.bp.OffsetDateTime;
import io.swagger.model.PriceApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-07T10:28:17.635Z[GMT]")
@RestController
public class ProductsApiController implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<PriceApiResponse> findByBrandIdProductIdDatetime(@NotNull @Min(1)@Parameter(in = ParameterIn.QUERY, description = "Id de la marca" ,required=true,schema=@Schema(allowableValues={  }, minimum="1"
)) @Valid @RequestParam(value = "brand_id", required = true) Integer brandId,@NotNull @Min(1)@Parameter(in = ParameterIn.QUERY, description = "Id del producto" ,required=true,schema=@Schema(allowableValues={  }, minimum="1"
)) @Valid @RequestParam(value = "product_id", required = true) Integer productId,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Fecha/hora de consulta" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "qry_date", required = true) OffsetDateTime qryDate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PriceApiResponse>(objectMapper.readValue("{\n  \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"price_list\" : 5,\n  \"price\" : 1.4658129805029452,\n  \"product_id\" : 6,\n  \"priority\" : 5,\n  \"curr\" : \"curr\",\n  \"brand_id\" : 0,\n  \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n}", PriceApiResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PriceApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PriceApiResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
