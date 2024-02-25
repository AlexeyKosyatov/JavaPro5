package ru.stepup.javapro.JavaPro5.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stepup.javapro.JavaPro5.dto.ProductDto;
import ru.stepup.javapro.JavaPro5.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final ProductService productService;

    public Controller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/by-userid")
    public List<ProductDto> getAllProductsByUserId(
            @RequestParam Long userId
    ) {
        return productService.selectAllByUserId(userId);
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(
            @PathVariable Long id
    ) {
        return productService.selectById(id);
    }

}
