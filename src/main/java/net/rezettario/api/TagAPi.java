package net.rezettario.api;

import net.rezettario.response.BaseResponse;
import net.rezettario.model.TagInfo;
import net.rezettario.response.SingleTagResponse;
import net.rezettario.response.TagsResponse;
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

@Path("tags")
@Tag(name = "Tags", description = "Tags API")
public class TagAPi {

    @Operation(description = "Tags Search by path variable host/id format", summary = "" +
            " Get Single Tag Information")
    @APIResponse(name = "getSingleTag",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = SingleTagResponse.class)))
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSingleTag(@PathParam("id") String id) {
        TagInfo tag = new TagInfo();
        tag.setAlias("abc");
        tag.setCreatedAt("2020-04-2020");
        tag.setCreatedBy(25);
        tag.setDescription("New Tag Description");
        tag.setName("New Tag");
        tag.setId(1234);
        tag.setUsedInRecipes(1200);
        SingleTagResponse response = new SingleTagResponse();
        response.setResult(tag);
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @Operation(description = "List all tag details", summary = "" +
            " Get All tags")
    @APIResponse(name = "getTags",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = TagsResponse.class)))
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTags(){
        TagInfo tagInfo = new TagInfo();
        TagsResponse response = new TagsResponse();
        response.setResults(Arrays.asList(tagInfo));
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @Operation(description = "Get Tags with query parameters  host?q=value&limit=value&offset=value&sort=value", summary = "" +
            "Get tags with given criteria")
    @APIResponse(name = "searchTag",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = TagsResponse.class)))
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchTag(@QueryParam("q") String q,
                               @QueryParam("limit") int limit,
                               @QueryParam("offset") int offset,
                               @QueryParam("sort") String sort){
        System.out.println("q:: "+ q + "limit:: " + limit + "offset ::" + offset + "sort::"+sort);
        TagInfo tagInfo = new TagInfo();
        TagsResponse response = new TagsResponse();
        response.setResults(Arrays.asList(tagInfo));
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @Operation(description = "Delete tag with id passed as path variable host/id", summary = "" +
            "Delete tag info with given id")
    @APIResponse(name = "deleteSingleTag",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = String.class)))
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSingleTag(@PathParam("id")  int id){
        return Response.status(Response.Status.OK).entity("{message:successfully deleted}").build();
    }

    @Operation(description = "Update tag details", summary = "" +
            "Update tag details with given details")
    @APIResponse(name = "updateTag",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = String.class)))
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTag(@Valid @RequestBody(name = "tag",required = true) TagInfo tagInfo){
        return Response.status(Response.Status.OK).build();
    }

    @Operation(description = "Update the existing tag info with id passed as path variable host/id", summary = "" +
            "Update existing tag info with given details")
    @APIResponse(name = "updateSingleTag",responseCode = "200",content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = String.class)))
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSingleTag(@Valid @RequestBody(name = "tag",required = true) TagInfo tagInfo, @PathParam("id") int id){
        return Response.status(Response.Status.OK).entity("{message:successfully updated}").build();
    }

}
