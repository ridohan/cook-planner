package com.ridohan.cookplanner.recipe;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends PanacheEntity {

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    public List<RecipeCompound> recipeCompounds = new ArrayList<>();

    public String name;

    public static Recipe findByName(String name){
        return find("name", name).firstResult();
    }

}
