package de.fherfurt.organization.resources;

import de.fherfurt.organization.storage.core.RepositoryFactory;
import de.fherfurt.organization.forum.core.Question;
import de.fherfurt.organization.forum.core.Answer;
import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ForumResource {

    private final ForumRepository forumRepository;

    public ForumResource() {
        this.forumRepository = RepositoryFactory.getInstance().getForumRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> getQuestions(
            @QueryParam("topic") @DefaultValue("") String topic,
            @QueryParam("title") @DefaultValue("") String title,
            @QueryParam("author") @DefaultValue("") String author
    ) {
        if(!topic.equals("")) {
            return this.forumRepository.getQuestionsByTopic( topic );
        }
        else if(!title.equals("")) {
            return this.forumRepository.getQuestionsByTitle( title );
        }
        else if(!author.equals("")) {
            return this.forumRepository.getQuestionsByAuthor( author );
        }
        else {
            return this.forumRepository.getAllQuestions();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createQuestion( Question questionToCreate ) {
        boolean success = this.forumRepository.addNewQuestion( questionToCreate );

        if( success ) {
            return Response.ok( questionToCreate ).build();
        }
        else {
            return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @GET
    @Path("{questionId:\\d+}")
    public Response getQuestion (
            @PathParam("questionId") int questionId,
            @QueryParam("answersOnly") @DefaultValue("false") boolean answersOnly
    ) {
        if( answersOnly ){
            return Response.ok( this.forumRepository.getAnswersFromQuestion( questionId ) ).build();
        }
        else {
            Question q = this.forumRepository.getQuestionById( questionId );

            if (q != null ) {
                return Response.ok( q ).build();
            }
            else {
                return Response.status( Response.Status.NOT_FOUND ).build();
            }
        }
    }

    @DELETE
    @Path("{questionId:\\d+}")
    public Response deleteQuestion(
            @PathParam("questionId") int questionId
    ) {
        Question q = this.forumRepository.getQuestionById( questionId );

        if( q != null ) {
            boolean success =  this.forumRepository.removeQuestion( questionId );

            if( success ) {
                return Response.ok().build();
            }
            else {
                return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
            }
        }
        else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }
    }

    @POST
    @Path("{questionId:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAnswerToQuestion(
            @PathParam("questionId") int questionId,
            Answer answer
    ) {
        Question q = this.forumRepository.getQuestionById( questionId );

        if( q != null) {
            this.forumRepository.addNewAnswerToQuestion( questionId, answer );
            return Response.ok().build();
        }
        return Response.status( Response.Status.NOT_FOUND ).build();
    }

    @GET
    @Path("/topic")
    public List<Topic> getAllTopics () {
        return this.forumRepository.getAllTopics();
    }

    @POST
    @Path("/topic/{newTopic}")
    public Response createTopic (
            @PathParam("newTopic") String newTopic
    ) {
        boolean success = this.forumRepository.addNewTopic( newTopic );

        if( success ) {
            return Response.ok().build();
        }
        else {
            return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @DELETE
    @Path("/topic/{topicId:\\d+}")
    public Response deleteRopic (
            @PathParam("topicId") int topicId
    ) {
        boolean success = this.forumRepository.removeTopic( topicId );

        if( success ) {
            return Response.ok().build();
        }
        else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }
    }
}
