package com.cydeo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Balance extends BaseEntity{
    private BigDecimal amount;
    @OneToOne
    private Customer customer;


    public Balance(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "amount=" + amount +
                '}';
    }
}
