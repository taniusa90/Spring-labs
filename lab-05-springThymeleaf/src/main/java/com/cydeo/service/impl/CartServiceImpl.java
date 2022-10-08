package com.cydeo.service.impl;

import com.cydeo.model.Cart;
import com.cydeo.model.CartItem;
import com.cydeo.model.Product;
import com.cydeo.service.CartService;
import com.cydeo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO, new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity) {
        //todo retrieve product from repository method
        Product productById = productService.findProductById(productId);

        //todo initialise cart item
        CartItem cartItem = new CartItem();
        cartItem.setProduct(productById);
        cartItem.setQuantity(quantity);

        //todo calculate cart total amount
        cartItem.setTotalAmount(productById.getPrice().multiply(BigDecimal.valueOf(quantity)));
        if (CART.getCartItemList().stream().noneMatch(item -> item.getProduct().getId().toString().equals(cartItem.getProduct().getId().toString()))){//it will check if the product is in the cart
           CART.getCartItemList().add(cartItem);
            BigDecimal totalOfCart = CART.getCartTotalAmount().add(cartItem.getTotalAmount());
            CART.setCartTotalAmount(totalOfCart);

        }

        //todo add to cart

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId) {
        //todo delete product object from cart using stream
        CartItem cartItemForDelete = getCart().getCartItemList().stream().filter(cartItem -> cartItem.getProduct().getId().toString().equals(productId.toString())).findFirst().orElseThrow();
        CART.getCartItemList().remove(cartItemForDelete);
        BigDecimal subtract = CART.getCartTotalAmount().subtract(cartItemForDelete.getTotalAmount());
        CART.setCartTotalAmount(subtract);




        return true;
    }

    @Override
    public Cart getCart() {
        return CART;
    }
}