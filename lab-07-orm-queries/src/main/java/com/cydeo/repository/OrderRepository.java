package com.cydeo.repository;

import com.cydeo.entity.Orders;
import com.cydeo.entity.Payment;
import com.cydeo.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Orders,Long> {
    //Write a derived query to get top 5 orders by order by total price desc
    List<Orders>findFirst5ByOrderByTotalPriceDesc();
    //Write a derived query to get all orders by customer email
    List<Orders>findByCustomer_Email(String email);
    //Write a derived query to get all orders by specific payment method
    List<Orders>findOrdersByPayment_PaymentMethod(PaymentMethod payment);
    //Write a derived query to check is there any orders by customer email
    boolean existsByCustomer_Email(String customer_email);
    //Write a native query to get all orders by specific product name
    @Query(value = "SELECT * FROM Orders o JOIN Cart c ON o.cart_id=c.id JOIN cart_item ci ON c.id=ci.cart_id join Product p ON ci.product_id=p.id WHERE p.name=?1",nativeQuery = true)
    List<Orders>retrieveAllOrdersByName(String name);
    //Write a native query to get all orders by specific categoryId
    @Query(value = "SELECT * FROM Orders o JOIN Cart c ON o.cart_id=c.id JOIN cart_item ci ON c.id=ci.cart_id join Product p ON ci.product_id=p.id Join product_category_rel pcr ON p.id=pcr.p_id JOIN Category ca ON pcr.c_id=ca.id WHERE ca.id=?1",nativeQuery = true)
    List<Orders>retrieveAllOrdersByCategoryId(@Param("id") Long id);
    //Write a derived query to get all orders by totalPrice and paidPrice are equals
   List<Orders> findByPaidPriceAndTotalPriceEquals(BigDecimal paidPrice,BigDecimal totalPrice);
    //Write a derived query to get all orders by totalPrice and paidPrice are not equals and discount is not null
    List<Orders>findByPaidPriceAndTotalPriceAndCart_DiscountIdNotNull(BigDecimal paidPrice, BigDecimal totalPrice);

}