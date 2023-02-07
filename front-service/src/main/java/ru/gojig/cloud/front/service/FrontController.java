package ru.gojig.cloud.front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.igojig.cloud.common.ProductDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class FrontController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<ProductDto> getAllProducts() {

        ProductDto[] productsArr = restTemplate.getForObject("http://product-service/api/v1/products", ProductDto[].class);
        //        productsList.forEach(o->o.setPrice(777));
        return productsArr == null ? Collections.emptyList() : Arrays.asList(productsArr);

    }

}
