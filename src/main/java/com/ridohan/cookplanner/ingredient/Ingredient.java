package com.ridohan.cookplanner.ingredient;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Ingredient  extends PanacheEntity {

    @Column(unique = true)
    public String name;

    @ManyToOne
    @JsonIgnore
    public IngredientFamily family;

    public static Ingredient findByName(String name){
        return find("name", name).firstResult();
    }


    @JsonGetter("family")
    public String getFamilyName() {
        return family.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Ingredient)) {
            return false;
        }

        Ingredient other = (Ingredient) obj;

        return Objects.equals(other.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

}
