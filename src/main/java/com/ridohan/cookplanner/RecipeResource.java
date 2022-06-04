package com.ridohan.cookplanner;

import com.ridohan.cookplanner.ingredient.IngredientFamily;
import com.ridohan.cookplanner.recipe.Recipe;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/recipe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecipeResource {


    @GET
    public List<Recipe> list() {
        return Recipe.listAll();
    }



    @POST
    @Transactional
    public Response add(@Valid Recipe recipe) {
        recipe.persist();
        return Response.status(Response.Status.CREATED).entity(recipe).build();
    }

    @PATCH
    @Transactional
    public List<IngredientFamily> update(@Valid Recipe recipe) {
        recipe.persist();
        return Recipe.listAll();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long recipeId) {
        if (Recipe.deleteById(recipeId)) {
            return Response.noContent().build();
        }else{
            throw new WebApplicationException("IngredientFamily with id of " + recipeId + " does not exist.", Response.Status.NOT_FOUND);
        }
    }





}