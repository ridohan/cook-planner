package com.ridohan.cookplanner.ingredient;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class IngredientFamily extends PanacheEntity {

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<Ingredient> ingredients = new HashSet<>();


    @Column(unique = true)
    public String name;


    public static IngredientFamily findByName(String name){
        return find("name", name).firstResult();
    }


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
