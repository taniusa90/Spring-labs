package com.cydeo.service;

import com.cydeo.dto.ProductDTO;
import com.cydeo.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService  {

    List<ProductDTO> retrieveListProduct();

    ProductDTO updateProduct(ProductDTO productDTO);

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> retrieveProductByCategoryAndPrice(List<Long> categoryList, BigDecimal price);

    ProductDTO retrieveByName(String name);

    List<ProductDTO> retrieveProductByTop3ProductByPrice();

    Integer countProductByPrice(BigDecimal price);

    List<ProductDTO>  retrieveProductByPriceAndQuantity(BigDecimal price, Integer quantity);

    List<ProductDTO> retrieveByCategory(Long categoryId);
}
