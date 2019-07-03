package com.ridohan.cookplanner.ingredient;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class IngredientFamily extends PanacheEntity {

    @ManyToMany
    public Set<Ingredient> ingredients;


    @Column(unique = true)
    public String name;



    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IngredientFamily)) {
            return false;
        }

        IngredientFamily other = (IngredientFamily) obj;

        return Objects.equals(other.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }


}
