package de.fherfurt.organization.resources;

import de.fherfurt.organization.models.Message;
import de.fherfurt.organization.storage.core.RepositoryFactory;
import de.fherfurt.organization.storage.repository.MessageRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class MessageResource {
    private final MessageRepository messageRepository;


    public MessageResource() {
        this.messageRepository = RepositoryFactory.getInstance().getMessageRepository();
    }

    /*
        CRUD Operations
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return this.messageRepository.getAllMessages();
    }

    @GET
    @Path("{messageId:\\d+}")
    public Response getMessage(
            @PathParam("messageId") int messageId
    ) {
        Message message = this.messageRepository.getMessage( messageId );

        if( message != null) {
            return Response.ok( message ).build();
        }
        else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMessage( Message messageToCreate) {
        boolean success = this.messageRepository.createMessage( messageToCreate );

        if( success ) {
            return Response.ok().build();
        }
        else {
            return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @PUT
    @Path("{messageId:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMessage(
            Message messageToUpdate,
            @PathParam("messageId") int messageId
    ) {
        if( this.messageRepository.getMessage( messageId ) == null ) {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }

        boolean success = this.messageRepository.updateMessage( messageToUpdate );

        if( success ) {
            return Response.ok().build();
        }
        else {
            return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @DELETE
    @Path("{messageId:\\d+}")
    public Response deleteMessage(
            @PathParam("messageId") int messageId
    ) {
        Message m = this.messageRepository.getMessage( messageId );

        if( m != null ) {
            return Response.ok().build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND ).build();
        }

    }
}
