package dev.lucas.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lucas.productservice.dto.ProductRequest;
import dev.lucas.productservice.dto.ProductResponse;
import dev.lucas.productservice.model.Product;
import dev.lucas.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponse> getAllProducts(){

        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
        
    }

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                        .name(productRequest.getName())
                        .description(productRequest.getDescription())
                        .price(productRequest.getPrice())
                        .build();

        productRepository.save(product);
        log.info("Product {} is saved.", product.getId());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
