package com.ridohan.cookplanner;

import com.ridohan.cookplanner.ingredient.Ingredient;
import com.ridohan.cookplanner.ingredient.IngredientFamily;
import com.ridohan.cookplanner.quantity.Quantity;
import com.ridohan.cookplanner.quantity.QuantityKindEnum;
import com.ridohan.cookplanner.recipe.Recipe;
import com.ridohan.cookplanner.recipe.RecipeCompound;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Path("/init")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InitDummyDataResource {


    @GET
    @Transactional
    public List<Recipe> init() {

        initIngredientFamily("Fruit", Arrays.asList("Apple", "Pear","Orange"));
        initRecipe("Fruit Salad", Map.of("Apple",new Quantity(QuantityKindEnum.UNIT,2D), "Pear",new Quantity(QuantityKindEnum.UNIT,1D)));

        return Recipe.listAll();

    }

    private void initRecipe(String recipeName, Map<String,Quantity> ingredients ){

        Recipe recipe = Recipe.findByName(recipeName);
        if(recipe == null){
            recipe = new Recipe();
            recipe.name = recipeName;

            for (Map.Entry<String, Quantity> entry : ingredients.entrySet()) {
                RecipeCompound recipeCompound = new RecipeCompound();
                recipeCompound.ingredient = findOrCreateIngredient(entry.getKey() );
                recipeCompound.quantity = entry.getValue();
                recipe.recipeCompounds.add(recipeCompound);
            }


            recipe.persistAndFlush();

        }

    }


        private void initIngredientFamily(String ingredientFamilyName, List<String> ingredients ){
        IngredientFamily ingredientFamily  = IngredientFamily.findByName(ingredientFamilyName);
        if(ingredientFamily == null){
            ingredientFamily = new IngredientFamily();
            ingredientFamily.name = ingredientFamilyName;

            for(String ingredientString : ingredients){
                Ingredient ingredient  = findOrCreateIngredient(ingredientString);
                ingredientFamily.ingredients.add(ingredient);
                ingredient.family=ingredientFamily;

            }

            ingredientFamily.persistAndFlush();
        }
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