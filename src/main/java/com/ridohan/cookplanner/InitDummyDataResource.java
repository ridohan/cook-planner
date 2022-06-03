package com.ridohan.cookplanner;

import com.ridohan.cookplanner.ingredient.Ingredient;
import com.ridohan.cookplanner.ingredient.IngredientFamily;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/init")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InitDummyDataResource {


    @GET
    @Transactional
    public List<IngredientFamily> hello() {

        Ingredient apple  = findOrCreateIngredient("Apple");
        Ingredient orange  = findOrCreateIngredient("Orange");
        Ingredient pear  = findOrCreateIngredient("Pear");
        Ingredient cherry  = findOrCreateIngredient("Cherry");


        IngredientFamily fruitFamily  = IngredientFamily.findByName("Fruit");
        if(fruitFamily == null){
            fruitFamily = new IngredientFamily();
            fruitFamily.name = "Fruit";
            fruitFamily.ingredients.add(apple);
            fruitFamily.ingredients.add(orange);
            fruitFamily.ingredients.add(pear);
            fruitFamily.ingredients.add(cherry);
            apple.family=fruitFamily;
            orange.family=fruitFamily;
            pear.family=fruitFamily;
            cherry.family=fruitFamily;

            fruitFamily.persistAndFlush();
        }


        return IngredientFamily.listAll();

    }

    public Ingredient findOrCreateIngredient(String name){
        Ingredient ingredient  = Ingredient.findByName(name);
        if(ingredient == null){
            ingredient = new Ingredient();
            ingredient.name = name;
        }
        return ingredient;
    }




}