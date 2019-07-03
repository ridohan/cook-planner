package com.ridohan.cookplanner.recipe;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class TemplateRecipe extends PanacheEntity {

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<RecipeCompound> recipeCompounds;

    public String name;
}
