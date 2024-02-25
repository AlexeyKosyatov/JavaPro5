package ru.stepup.javapro.JavaPro5.service;

import org.springframework.stereotype.Component;
import ru.stepup.javapro.JavaPro5.dto.ProductDto;

import java.util.List;

@Component
public interface ProductService {
    void create(ProductDto productDto);
    void deleteAll();
    List<ProductDto> selectAllByUserId(Long userId);
    ProductDto selectById(Long id);
    void deleteById(Long id);
}

