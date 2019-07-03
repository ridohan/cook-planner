package com.ridohan.cookplanner;

import com.ridohan.cookplanner.ingredient.IngredientFamily;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ingredientFamily")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IngredientFamilyResource {


    @GET
    public List<IngredientFamily> list() {
        return IngredientFamily.listAll();
    }



    @POST
    @Transactional
    public Response add(@Valid IngredientFamily ingredientFamily) {
        ingredientFamily.persist();
        return Response.status(Response.Status.CREATED).entity(ingredientFamily).build();
    }

    @PATCH
    @Transactional
    public List<IngredientFamily> update(@Valid IngredientFamily ingredientFamily) {
        ingredientFamily.persist();
        return IngredientFamily.listAll();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long ingredientFamilyId) {
        IngredientFamily entity = IngredientFamily.findById(ingredientFamilyId);
        if (entity == null) {
            throw new WebApplicationException("IngredientFamily with id of " + ingredientFamilyId + " does not exist.", Response.Status.NOT_FOUND);
        }


        entity.delete();
        return Response.noContent().build();
    }





}