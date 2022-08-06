package de.fherfurt.organization.resources;

import de.fherfurt.organization.core.models.Answer;
import de.fherfurt.organization.storage.core.RepositoryFactory;
import de.fherfurt.organization.storage.repository.AnswerRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class AnswerResource {
    private final AnswerRepository answerRepository;

    public AnswerResource() {
        this.answerRepository = RepositoryFactory.getInstance().getAnswerRepository();
    }

    /*
        CRUD Operations
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Answer> getAnswers() {
        return this.answerRepository.getAllAnswers();
    }

    @GET
    @Path("{answerId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAnswer(
            @PathParam("answerId") int answerId
    ) {
        Answer a = this.answerRepository.getAnswer( answerId );

        if( a != null ) {
            return Response.ok( a ).build();
        }
        else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAnswer( Answer answerToCreate ) {
        boolean success = this.answerRepository.createAnswer( answerToCreate );

        if( success ) {
            return Response.ok().build();
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @PUT
    @Path("{answerId:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAnswer(
            Answer answerToUpdate,
            @PathParam("answerId") int answerId
    ) {
        if( this.answerRepository.getAnswer( answerId ) == null ) {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }

        boolean success = this.answerRepository.updateAnswer( answerToUpdate );

        if( success ) {
            return Response.ok().build();
        }
        else {
            return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @DELETE
    @Path("{answerId:\\d+}")
    public Response deleteAnswer(
            @PathParam("answerId") int answerId
    ) {
        Answer a = this.answerRepository.getAnswer( answerId );

        if( a != null ) {
            return Response.ok().build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND ).build();
        }
    }
}
