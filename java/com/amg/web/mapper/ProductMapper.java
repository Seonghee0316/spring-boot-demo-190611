package com.amg.web.mapper;

import java.util.List;

import com.amg.web.domain.ProductDTO;

import org.springframework.stereotype.Repository;

/**
 * ProductMapper
 */
@Repository
public interface ProductMapper {
    public void insertProduct(ProductDTO Product);
    public List<ProductDTO> selectProducts();
    public List<ProductDTO> selectProductsByOption(ProductDTO option);
    public ProductDTO selectProductsByProductId(String productId);
    public void updateProduct(ProductDTO product);
    public void deleteProduct(ProductDTO product);
    
}