package de.fherfurt.organization.resources;

import de.fherfurt.organization.core.models.Question;
import de.fherfurt.organization.storage.core.RepositoryFactory;
import de.fherfurt.organization.storage.repository.QuestionRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class QuestionResource {
    private final QuestionRepository questionRepository;

    public QuestionResource() {
        this.questionRepository = RepositoryFactory.getInstance().getQuestionRepository();
    }

    @GET
    @Path("{questionId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAnswersToQuestion (
            @PathParam("questionId") int questionId
    ) {
        Question q = this.questionRepository.getQuestion( questionId );

        if( q != null ) {
            return Response.ok( q.getAnswers() ).build();
        }
        else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }
    }

    /*
        CRUD Operations
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> getQuestions() {
        return this.questionRepository.getAllQuestions();
    }

    @GET
    @Path("{questionId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuestion(
            @PathParam("questionId") int questionId
    ) {
        Question q = this.questionRepository.getQuestion( questionId );

        if( q != null ) {
            return Response.ok( q ).build();
        }
        else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createQuestion( Question questionToCreate ) {
        boolean success = this.questionRepository.createQuestion( questionToCreate );

        if( success ) {
            return Response.ok( questionToCreate ).build();
        }
        else {
            return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @PUT
    @Path("{questionId:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateQuestion(
            Question questionToUpdate,
            @PathParam("questionId") int questionId
    ) {
        if( this.questionRepository.getQuestion( questionId ) == null ) {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }

        boolean success = this.questionRepository.updateQuestion( questionToUpdate );

        if( success ) {
            return Response.ok().build();
        }
        else {
            return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @DELETE
    @Path("{questionId:\\d+}")
    public Response deleteQuestion(
            @PathParam("questionId") int questionId
    ) {
        Question q = this.questionRepository.getQuestion( questionId );

        if( q != null ) {
            this.questionRepository.deleteQuestion( questionId );
            return Response.ok().build();
        }
        else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }
    }
}
