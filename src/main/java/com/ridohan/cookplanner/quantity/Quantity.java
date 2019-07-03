package com.ridohan.cookplanner.quantity;

import javax.persistence.Embeddable;

@Embeddable
public class Quantity {

    public QuantityKindEnum quantityKind;
    public Double amount;

    public Quantity() {
    }

    public Quantity(QuantityKindEnum quantityKind, Double amount) {
        this.quantityKind = quantityKind;
        this.amount = amount;
    }
}
