package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.exceptions.ApiException;
import io.swagger.exceptions.NotFoundException;
import io.swagger.model.PriceApiResponse;
import io.swagger.model.PriceApiResponseInner;
import io.swagger.model.Prices;
import io.swagger.service.ProductsService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-07T10:28:17.635Z[GMT]")
@RestController
@CrossOrigin(origins="*")
public class ProductsApiController implements ProductsApi {

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
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*"))) {
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
                    throw new NotFoundException(HttpStatus.NOT_FOUND.value(), "BrandId/ProductId/Datetime not found");

                }
                return new ResponseEntity<List<PriceApiResponseInner>>(priceApiResponse, httpStatus);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                throw new RuntimeException(e);
            }
        }

        //return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        throw new ApiException(HttpStatus.NOT_IMPLEMENTED.value(), "FUNCITONALLITY NOT IMPLEMENTED");

    }
}
