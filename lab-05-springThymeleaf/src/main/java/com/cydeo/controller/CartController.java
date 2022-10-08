package com.cydeo.controller;

import com.cydeo.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String getCart(Model model){

        model.addAttribute("cart", cartService.getCart());

        return "/cart/show-cart";
    }

    @GetMapping("/addToCart/{id}/{quantity}")
    public String addProductToCart(@PathVariable("id")UUID id,@PathVariable Integer quantity){

        cartService.addToCart(id,quantity);


        return "redirect:/cart";
    }
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id")UUID id){

        cartService.deleteFromCart(id);


        return "redirect:/cart";
    }




}
