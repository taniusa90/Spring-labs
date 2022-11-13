package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
@Getter
@Setter
@NoArgsConstructor
public class CartItem extends BaseEntity{
    private Integer quantity;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Cart cart;

    public CartItem(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "quantity=" + quantity +
                '}';
    }
}
