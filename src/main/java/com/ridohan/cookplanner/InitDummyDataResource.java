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

        Ingredient apple  = Ingredient.findByName("Apple");
        if(apple == null){
            apple = new Ingredient();
            apple.name = "Apple";
        }


        IngredientFamily fruitFamily  = IngredientFamily.findByName("Fruit");
        if(fruitFamily == null){
            fruitFamily = new IngredientFamily();
            fruitFamily.name = "Fruit";
            fruitFamily.ingredients.add(apple);
            apple.family=fruitFamily;

            fruitFamily.persistAndFlush();
        }









        return IngredientFamily.listAll();

    }





}