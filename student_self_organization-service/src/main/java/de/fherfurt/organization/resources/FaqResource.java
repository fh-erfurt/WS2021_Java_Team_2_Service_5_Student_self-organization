package de.fherfurt.organization.resources;

import de.fherfurt.organization.faq.model.Element;
import de.fherfurt.organization.faq.repository.FaqRepositioryFactory;
import de.fherfurt.organization.faq.repository.IFaqRepositiory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class FaqResource {

    private final IFaqRepositiory faqRepository;

    public FaqResource() {
        this.faqRepository = FaqRepositioryFactory.getInstance().getFaqRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Element> getAllElements(){
        return this.faqRepository.getAllElements();
    }

    @GET
    @Path("{elementId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getElement(@PathParam("elementId") int elementId){
        Element element = this.faqRepository.getElementById(elementId);

        if(element != null){
            return Response.ok(element).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createElement(Element elementToCreate){
        boolean success = this.faqRepository.createElement(elementToCreate);

        if(success){
            return Response.ok(elementToCreate).build();
        }
        else{
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("{elementId:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateElement(Element elementToUpdate){
        boolean success = this.faqRepository.updateElementById(elementToUpdate);

        if(success){
            return Response.ok().build();
        }
        else{
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{elementId:\\d+}")
    public Response deleteElement(@PathParam("elementId") int elementId){
        Element element = this.faqRepository.getElementById(elementId);

        if(element != null){
            this.faqRepository.deleteElementById(elementId);
            return Response.ok().build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}