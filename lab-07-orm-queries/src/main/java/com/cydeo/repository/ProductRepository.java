package com.cydeo.repository;

import com.cydeo.entity.Category;
import com.cydeo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> {
    //Write a derived query to get top 3 product order by price desc
    List<Product>findFirs3tByOrderByPriceDesc();
    //Write a derived query to get product by specific name
    Product findByName(String name);
    //Write a derived query to get product by specific category
    List<Product> findAllByCategoryContaining (Category category);
    //Write a derived query to get count by price greater than specific amount
    Integer countAllByPriceGreaterThan(BigDecimal price);
    //Write a derived query to get all product by quantity greater than or equal specific count
    List<Product>findAllByQuantityGreaterThanEqual(Integer quantity);
    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count
    @Query(value = "SELECT * FROM Product where price>?1 AND quantity<?2",nativeQuery = true)
    List<Product>retrieveAllProductsByPrice(BigDecimal price,Integer quantity);
    //Write a native query to get all product by specific categoryId
    @Query(value = "SELECT * FROM Product p JOIN product_category_rel pcr  On p.id=pcr.p_id WHERE pcr.c_id=?1",nativeQuery = true)
    List<Product>retrieveAllProductsByCategory(Long id);
    //Write a native query to get all product by specific categoryId and price greater than specific amount
    @Query(value = "SELECT * FROM Product p JOIN product_category_rel pcr  On p.id=pcr.p_id WHERE pcr.c_id=?1 AND p.price>?2",nativeQuery = true)
    List<Product>retrieveAllProductsByCategoryAndAmount(Long id,BigDecimal price);


}