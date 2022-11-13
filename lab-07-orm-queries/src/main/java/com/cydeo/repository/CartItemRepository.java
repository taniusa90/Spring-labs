package com.cydeo.repository;

import com.cydeo.Lab07OrmQueriesApplication;
import com.cydeo.entity.CartItem;
import com.cydeo.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CartItemRepository extends JpaRepository<CartItem, Lab07OrmQueriesApplication> {

    //Write a derived query to get count cart items
     Integer countCartItemBy();
    //Write a derived query to get cart items for specific cart state
      List<CartItem >findByCart_CartState(CartState cart_cartState);
    //Write a native query to get cart items for specific cart state and product name
    @Query(value = "SELECT * FROM cart_item ci  JOIN cart c  ON ci.cart_id=c.id JOIN product p ON p.id=ci.product_id where c.cart_state=?1 AND p.name=?2",nativeQuery = true)
  List<CartItem> retrieveCartItemsByStateAndName(@Param("cart_state") String cart_state, @Param("name") String name);


    //Write a native query to get cart items for specific cart state and without discount
    @Query(value = "SELECT * FROM cart_item ci JOIN cart c ON ci.cart_id=c.id WHERE c.cart_state=?1 AND C.discount_id IS NULL ",nativeQuery = true)
    List<CartItem>retrieveCartItemsByCartState(@Param("cart_state") String cart_state);
    //Write a native query to get cart items for specific cart state and with specific Discount type

    @Query(value = "SELECT * FROM cart_item ci JOIN cart c ON ci.cart_id=c.id JOIN discount d ON  c.discount_id=d.id WHERE c.cart_state=?1 AND  d.discount_type=?2",nativeQuery = true)
    List<CartItem>retrieveCartItemsByCartState2(@Param("cart_state") String cart_state,@Param("discount_type")String discount_type);
}
