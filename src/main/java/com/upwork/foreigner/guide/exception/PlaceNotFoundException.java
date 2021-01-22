package com.upwork.foreigner.guide.exception;


import lombok.NoArgsConstructor;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@NoArgsConstructor
public class PlaceNotFoundException extends Exception implements
        ExceptionMapper<PlaceNotFoundException> {

    public PlaceNotFoundException(String string) {
        super(string);
    }

    @Override
    public Response toResponse(final PlaceNotFoundException exception) {
        return Response.status(404).entity(exception.getMessage())
                .type("text/plain").build();
    }
}
