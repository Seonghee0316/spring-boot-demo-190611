package com.amg.web.servicelmpl;

import java.util.List;

import com.amg.web.domain.ProductDTO;
import com.amg.web.service.ProductService;

import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public void addProduct(ProductDTO Product) {

    }

    @Override
    public List<ProductDTO> findProducts() {
        return null;
    }

    @Override
    public List<ProductDTO> findProductsByOption(ProductDTO option) {
        return null;
    }

    @Override
    public ProductDTO findProductsByProductId(String productId) {
        return null;
    }

    @Override
    public void updateProduct(ProductDTO product) {

    }

    @Override
    public void deleteProduct(ProductDTO product) {

    }

    
}