package de.fherfurt.organization.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api")
public class BaseResource {

    @GET
    public String info() {
        return "Hello from Base Resource";
    }

    @Path("/forum")
    public ForumResource getForumResource() {
        return new ForumResource();
    }


}
