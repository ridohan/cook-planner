package com.ridohan.cookplanner;

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
    public void hello() {
        IngredientFamily fruit = new IngredientFamily();
        fruit.name = "Fruit";
        fruit.persist();

    }





}