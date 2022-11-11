package io.swagger.api;

import io.swagger.model.PriceApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.PriceApiResponseInner;
import io.swagger.model.Prices;
import io.swagger.service.ProductsService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.OffsetDateTime;

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


    /**
     * GET /products/price : Busca un artículo por marca, id prod. y fecha/hora Permite buscar un
     * artículo indicando el código de marca, el id de artículo y la fecha/hora de consulta
     *
     * @param brandId   Id de la marca (required)
     * @param productId Id del producto (required)
     * @param qryDate   Fecha/hora de consulta (required)
     * @return successful operation (status code 200) or Invalid BrandId/ProductId/Datetime value
     * (status code 400) or BrandId/ProductId/Datetime not found (status code 404) or An error occured
     * while processing the request. Please, contact admin@business.com  (status code 500)
     */
    @Override
    public ResponseEntity<List<PriceApiResponseInner>> findByBrandIdProductIdDatetime(
        Integer brandId,
        Integer productId, java.time.OffsetDateTime qryDate) {
        //return ProductsApi.super.findByBrandIdProductIdDatetime(brandId, productId, qryDate);
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                List<Prices> prices = productsService.findByBrandIdProductIdDatetime(brandId, productId, qryDate);
                PriceApiResponse priceApiResponse;
                HttpStatus httpStatus;

                if (prices != null && prices.size() > 0) {
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
                    HttpHeaders responseHeaders = new HttpHeaders();
                    responseHeaders.set("message", "Record not found");
                    return new ResponseEntity<List<PriceApiResponseInner>>(priceApiResponse, responseHeaders, httpStatus);

//                    getRequest().ifPresent(request -> {
//                        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
//                            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
//                                String exampleString = "{ \"end_date\" : \"2000-01-23T04:56:07.000+00:00\", \"price_list\" : 5, \"price\" : 1.4658129805029452, \"product_id\" : 6, \"priority\" : 5, \"curr\" : \"curr\", \"brand_id\" : 0, \"start_date\" : \"2000-01-23T04:56:07.000+00:00\" }";
//                                ApiUtil.setExampleResponse(request, "application/json", exampleString);
//                                break;
//                            }
//                        }
//                    });

                }
                //return new ResponseEntity<PriceApiResponse>(priceApiResponse, httpStatus);
                return new ResponseEntity<List<PriceApiResponseInner>>(priceApiResponse, httpStatus);
//                return new ResponseEntity<PriceApiResponse>(
//                    productsService.findByBrandIdProductIdDatetime(brandId, productId, qryDate),
//                    HttpStatus.OK
//                );
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
