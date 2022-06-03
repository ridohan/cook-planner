package com.ridohan.cookplanner.recipe;

import com.ridohan.cookplanner.ingredient.Ingredient;
import com.ridohan.cookplanner.quantity.Quantity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class RecipeCompound extends PanacheEntity {

    @ManyToOne
    public Ingredient ingredient;
    @Embedded
    public Quantity quantity;

    public Quantity getQuantity() {
        return quantity;
    }
}
