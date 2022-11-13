package com.cydeo.repository;

import com.cydeo.entity.Cart;
import com.cydeo.enums.CartState;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart,Long> {
    //Write a derived query to get all cart by specific discount type
    List<Cart>findByDiscount_DiscountType(DiscountType discount_discountType);
    //Write a JPQL query to get all cart by customer
    @Query("SELECT c FROM Cart c WHERE c.customer.id=?1 ")
    List<Cart>retrieveAllByCustomer(@Param("id") Long id);
    //Write a derived query to get all cart by customer and cart state
    List<Cart>findByCustomerIdAndCartState(Long id, CartState cart_cartState);
    //Write a derived query to get all cart by customer and cart state and discount is null condition
    List<Cart>findByCustomerIdAndCartStateAndDiscountNull(Long id,CartState cart_cartState);
    //Write a native query to get all cart by customer and cart state and discount is not null condition
    @Query(value = "SELECT * FROM cart ca join customer c ON ca.customer_id=c.id JOIN discount d On ca.discount_id=d.id WHERE c.id=?1 AND cart_state=?2  AND d.id <> NULL  ",nativeQuery = true)
    List<Cart>retrieveAllCartByDiscount(Long id,String cartState);
}