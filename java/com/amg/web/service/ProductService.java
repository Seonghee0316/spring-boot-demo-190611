package com.amg.web.service;

import java.util.List;

import com.amg.web.domain.ProductDTO;

import org.springframework.stereotype.Component;

/**
 * ProductService
 */
@Component
public interface ProductService {
    public void addProduct(ProductDTO Product);
    public List<ProductDTO> findProducts();
    public List<ProductDTO> findProductsByOption(ProductDTO option);
    public ProductDTO findProductsByProductId(String productId);
    public void updateProduct(ProductDTO product);
    public void deleteProduct(ProductDTO product);
    
}