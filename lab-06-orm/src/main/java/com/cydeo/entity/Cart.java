package com.cydeo.entity;

import com.cydeo.enums.CartState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cart extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private CartState cartState;
    @OneToOne(mappedBy = "cart")
    private Order orders;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Discount discount;
    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItem;





    public Cart(CartState cartState) {
        this.cartState = cartState;
    }
}
