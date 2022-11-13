package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cart_item")
public class CartItem extends BaseEntity{
    private Integer quantity;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Cart cart;





}
