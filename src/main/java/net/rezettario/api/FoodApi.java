package net.rezettario.api;

import net.rezettario.response.FoodsResponse;
import net.rezettario.model.Food;
import net.rezettario.response.SingleFoodResponse;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@Path("foods")
@Tag(name = "Food", description = "Food API")
public class FoodApi {

    @Operation(description = "Food Search by /id format", summary = "" +
            " Get Single Food Information")
    @APIResponse(name = "getSingleFood", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = SingleFoodResponse.class)
            )
        )

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSingleFood(@PathParam("id") String id) {
        Food food = new Food();
        SingleFoodResponse foodResponse= new SingleFoodResponse();
        foodResponse.setResult(food);
        return Response.status(Response.Status.OK).entity(foodResponse).build();
    }

    @Operation(description = "Get all foods ", summary = "" +
            " Get all foods details")
    @APIResponse(name = "getFoods", responseCode = "200", content = @Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = FoodsResponse.class)
            )
    )
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFoods() {
        Food food = new Food();
        food.setId(123);
        food.setName("New Food");
        food.setGenericName("New GenericName");
        food.setSynonyms(Arrays.asList("synonyms1", "synonyms2", "synonyms3"));
        food.setTags(Arrays.asList("abc", "def", "jkl"));
        FoodsResponse response = new FoodsResponse();
        response.setResults(Arrays.asList(food));
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @Operation(description = "Get Foods with query parameters host?q=value&limit=value&offset=value&sort=value", summary = "" +
            "Get food details with given criteria")
    @APIResponse(name = "searchFood", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = FoodsResponse.class)
    )
    )
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchFood(@QueryParam("q") String q,
                               @QueryParam("limit") int limit,
                               @QueryParam("offset") int offset,
                               @QueryParam("sort") String sort) {
        System.out.println("q:: " + q + "limit:: " + limit + "offset ::" + offset + "sort::" + sort);
        Food food = new Food();
        food.setId(123);
        food.setName("New Food");
        food.setGenericName("New GenericName");
        food.setSynonyms(Arrays.asList("synonyms1", "synonyms2", "synonyms3"));
        food.setTags(Arrays.asList("abc", "def", "jkl"));
        FoodsResponse response = new FoodsResponse();
        response.setResults(Arrays.asList(food));
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @Operation(description = "Delete food with id passed as path variable host/id", summary = "" +
            "Delete food with given id")
    @APIResponse(name = "deleteFood", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = String.class)))
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFood(@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity("{message:successfully deleted}").build();
    }

    @Operation(description = "Insert a new food item", summary = "" +
            "Insert a new food with given details")
    @APIResponse(name = "insertFood", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = String.class)))
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertFood(@Valid @RequestBody(name = "food", required = true) Food food) {
        return Response.status(Response.Status.OK).entity("{message:successfully inserted}").build();
    }

    @Operation(description = "Update the existing food details with id passed as path variable host/id", summary = "" +
            "Update existing food item with given details")
    @APIResponse(name = "updateFood", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = String.class)))
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFood(@Valid @RequestBody(name = "food", required = true) Food food, @PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity("{message:successfully updated}").build();
    }
}
