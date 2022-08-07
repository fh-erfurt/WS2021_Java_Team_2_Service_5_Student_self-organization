package de.fherfurt.organization.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * base resource for Rest-API
 * collects all other resources
 */
@Path("/api")
public class BaseResource {

    /*
        greeting message
     */
    @GET
    public String info() {
        return "Hello from Base Resource";
    }

    /*
        messages
     */
    @Path("/messages")
    public MessageResource getMessageResource() {
        return new MessageResource();
    }

    /*
        answers
     */
    @Path("/answers")
    public AnswerResource getAnswerResource() {
        return new AnswerResource();
    }

    /*
        questions
     */
    @Path("/questions")
    public QuestionResource getQuestionResource() {
        return new QuestionResource();
    }

    /*
        faq
     */
    @Path("/faq")
    public FaqResource getFaqResource(){
        return new FaqResource();
    }

    /*
        to-do
     */
    @Path("/todo")
    public TaskResource getTaskResource(){
        return new TaskResource();
    }
}
