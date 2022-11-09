package io.swagger.api;

import io.swagger.model.PriceApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.PriceApiResponseInner;
import io.swagger.model.Prices;
import io.swagger.service.ProductsService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-07T10:28:17.635Z[GMT]")
@RestController
//@CrossOrigin(origins="*")
public class ProductsApiController implements ProductsApi {

    //private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private final ProductsService productsService;

    @Autowired
    public ProductsApiController(ObjectMapper objectMapper, HttpServletRequest request,
        ProductsService productsService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.productsService = productsService;
    }

    public ResponseEntity<PriceApiResponse> findByBrandIdProductIdDatetime(
        @NotNull
        @Min(1)
        @Parameter(in = ParameterIn.QUERY, description = "Id de la marca", required=true, schema=@Schema(allowableValues={  }, minimum="1"))
        @Valid
        @RequestParam(value = "brand_id", required = true)
        Integer brandId,
        @NotNull
        @Min(1)
        @Parameter(in = ParameterIn.QUERY, description = "Id del producto", required=true, schema=@Schema(allowableValues={  }, minimum="1"))
        @Valid
        @RequestParam(value = "product_id", required = true)
        Integer productId,
        @Parameter(in = ParameterIn.QUERY, description = "Fecha/hora de consulta", required=true, schema=@Schema())
        @RequestParam(value = "qry_date", required = true)
        @NotNull
        @Valid
        OffsetDateTime qryDate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                List<Prices> prices = productsService.findByBrandIdProductIdDatetime(brandId, productId, qryDate);
                PriceApiResponse priceApiResponse;
                HttpStatus httpStatus;

                if (prices != null && prices.get(0).getProductId() > 0) {
                    PriceApiResponseInner priceApiResponseInner = new PriceApiResponseInner()
                        .brandId(prices.get(0).getBrandId())
                        .productId(prices.get(0).getProductId())
                        .price(prices.get(0).getPrice())
                        .priceList(prices.get(0).getPriceList())
                        .priority(prices.get(0).getPriority())
                        .startDate(prices.get(0).getStartDate())
                        .endDate(prices.get(0).getEndDate())
                        .curr(prices.get(0).getCurr().toString());
                    priceApiResponse = new PriceApiResponse();
                    priceApiResponse.add(priceApiResponseInner);
                    httpStatus = HttpStatus.OK;
                } else {
                    priceApiResponse = new PriceApiResponse();
                    httpStatus = HttpStatus.NOT_FOUND;
                }
                return new ResponseEntity<PriceApiResponse>(priceApiResponse, httpStatus);
//                return new ResponseEntity<PriceApiResponse>(
//                    productsService.findByBrandIdProductIdDatetime(brandId, productId, qryDate),
//                    HttpStatus.OK
//                );
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PriceApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PriceApiResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
