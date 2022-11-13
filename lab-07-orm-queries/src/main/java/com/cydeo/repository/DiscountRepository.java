package com.cydeo.repository;

import com.cydeo.entity.Discount;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


public interface DiscountRepository extends JpaRepository<Discount,Long> {
    //Write a derived query to get discount by name
    Discount findByName(String name);
    //Write a derived query to get all discounts greater than discount amount
    List<Discount>getByDiscountGreaterThan(BigDecimal amount);
    //Write a derived query to get all discounts by specific discount type
    List<Discount>getByDiscountType(DiscountType discountType);
    //Write a JPQL query to get all discounts amount between range of discount amount
    @Query("SELECT d FROM Discount d where d.discount between ?1 AND ?2")
    List<Discount>retrieveDiscountBetweenRange(BigDecimal amount1,BigDecimal amount2);
}