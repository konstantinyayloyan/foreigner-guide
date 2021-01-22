package com.upwork.foreigner.guide.controller;

import com.upwork.foreigner.guide.dto.PlaceDTO;
import com.upwork.foreigner.guide.exception.PlaceNotFoundException;
import com.upwork.foreigner.guide.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/place")
@Produces(MediaType.APPLICATION_JSON)
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/places")
    public Response get(@NotEmpty @QueryParam("name") final String name,
                        @NotEmpty @QueryParam("type") final String type) throws PlaceNotFoundException {
        final PlaceDTO placeDTO = placeService.findByNameAndType(name, type);
        return Response.ok().entity(placeDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/places")
    public Response create(@Valid final PlaceDTO placeDTO) {
        placeService.save(placeDTO);
        return Response.ok().entity("Successfully saved").build();
    }
}
