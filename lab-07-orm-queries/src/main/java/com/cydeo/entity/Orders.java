package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Orders extends BaseEntity {
    private BigDecimal paidPrice;
    private BigDecimal totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @OneToOne(fetch = FetchType.LAZY)
    private Payment payment;
    @OneToOne(fetch = FetchType.LAZY)
    private Cart cart;


    public Orders(BigDecimal paidPrice, BigDecimal totalPrice) {
        this.paidPrice = paidPrice;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "paidPrice=" + paidPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
