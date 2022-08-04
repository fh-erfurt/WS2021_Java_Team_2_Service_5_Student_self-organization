package de.fherfurt.organization.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api")
public class BaseResource {

    @GET
    public String info() {
        return "Hello from Base Resource";
    }

    @Path("/messages")
    public MessageResource getMessageResource() {
        return new MessageResource();
    }

    @Path("/answers")
    public AnswerResource getAnswerResource() {
        return new AnswerResource();
    }

    @Path("/questions")
    public QuestionResource getQuestionResource() {
        return new QuestionResource();
    }

    @Path("/faq")
    public FaqResource getFaqResource(){
        return new FaqResource();
    }
}
