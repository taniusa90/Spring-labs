package com.cydeo.entity;

import com.cydeo.enums.QuantityType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter

public class Ingredients {

    private String name;
    private int quantity;
    private QuantityType quantityType;
}
