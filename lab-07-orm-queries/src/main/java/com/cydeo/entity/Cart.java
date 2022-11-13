package com.cydeo.entity;

import com.cydeo.enums.CartState;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private CartState cartState;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Discount discount;






    public Cart(CartState cartState) {
        this.cartState = cartState;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartState=" + cartState +
                '}';
    }
}
