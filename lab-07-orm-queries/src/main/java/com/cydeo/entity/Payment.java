package com.cydeo.entity;

import com.cydeo.enums.PaymentMethod;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment extends BaseEntity{

    private BigDecimal paidPrice;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @OneToOne(mappedBy ="payment" )
    private Orders orders;

    public Payment(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paidPrice=" + paidPrice +
                '}';
    }
}
