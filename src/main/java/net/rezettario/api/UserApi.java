package net.rezettario.api;

import net.rezettario.model.User;
import net.rezettario.response.SingleUserResponse;
import net.rezettario.response.UsersResponse;
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


@Path("users")
@Tag(name = "User",description = "User API")
public class UserApi {

    @Operation(description = "User Search by path variable host/id format", summary = "" +
            " Get Single User Information")
    @APIResponse(name = "getSingleUser",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = SingleUserResponse.class)))
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSingleUser(@PathParam("id") String id) {
        User user = new User();
        user.setAlias("alias");
        user.setCreatedAt("2020-04-2020");
        user.setCreatedBy(25);
        user.setFirstname("First Name");
        user.setLastname("Last Name");
        user.setId(1234);
        user.setProfileImagePath("/mypaath/name.jpg");
        SingleUserResponse response = new SingleUserResponse();
        response.setResult(user);
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @Operation(description = "List all users details", summary = "" +
            " Get All users")
    @APIResponse(name = "getUsers",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = UsersResponse.class)))
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
        User user = new User();
        UsersResponse response = new UsersResponse();
        response.setResults(Arrays.asList(user));
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @Operation(description = "Get users with query parameters  host?q=value&limit=value&offset=value&sort=value", summary = "" +
            "Get users with given criteria")
    @APIResponse(name = "searchUser",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = UsersResponse.class)))
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchUser(@QueryParam("q") String q,
                               @QueryParam("limit") int limit,
                               @QueryParam("offset") int offset,
                               @QueryParam("sort") String sort){
        System.out.println("q:: "+ q + "limit:: " + limit + "offset ::" + offset + "sort::"+sort);
        User user = new User();
        UsersResponse response = new UsersResponse();
        response.setResults(Arrays.asList(user));
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @Operation(description = "Delete user with id passed as path variable host/id", summary = "" +
            "Delete user with given id")
    @APIResponse(name = "deleteUser",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = String.class)))
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id")  int id){
        return Response.status(Response.Status.OK).entity("{message:successfully deleted}").build();
    }

    @Operation(description = "Create a new User", summary = "" +
            "Create a new user with given details")
    @APIResponse(name = "createUser",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = String.class)))
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(@Valid @RequestBody(name = "user",required = true) User user){
        return Response.status(Response.Status.OK).build();
    }

    @Operation(description = "Update the existing user with id passed as path variable host/id", summary = "" +
            "Update existing user with given details")
    @APIResponse(name = "updateUser",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = String.class)))
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@Valid  @RequestBody(name = "user",required = true) User user, @PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity("{message:successfully updated}").build();
    }
}