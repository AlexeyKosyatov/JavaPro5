package ru.stepup.javapro.JavaPro5.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stepup.javapro.JavaPro5.dto.ProductDto;
import ru.stepup.javapro.JavaPro5.entity.ProductEntity;
import ru.stepup.javapro.JavaPro5.repository.ProductDao;
import ru.stepup.javapro.JavaPro5.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void create(ProductDto productDto) {
        var productEntity = new ProductEntity(
                productDto.getId(),
                productDto.getAccountNumber(),
                productDto.getBalance(),
                productDto.getType(),
                productDto.getUserId());
        productDao.create(productEntity);
    }

    @Override
    public void deleteAll() {
        productDao.deleteAll();
    }

    @Override
    public List<ProductDto> selectAllByUserId(Long userId) {
        return productDao.selectAllByUserId(userId)
                .stream()
                .map(productEntity -> new ProductDto(
                        productEntity.getId(),
                        productEntity.getAccountNumber(),
                        productEntity.getBalance(),
                        productEntity.getType(),
                        productEntity.getUserId()))
                .toList();
    }

    @Override
    public ProductDto selectById(Long id) {
        var productEntity = productDao.selectById(id);
        if(productEntity != null) {
            return new ProductDto(
                    productEntity.getId(),
                    productEntity.getAccountNumber(),
                    productEntity.getBalance(),
                    productEntity.getType(),
                    productEntity.getUserId());
        }
        else {
            throw new RuntimeException("Продукт не найден id = " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
}

