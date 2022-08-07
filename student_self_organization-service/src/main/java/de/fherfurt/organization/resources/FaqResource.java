package de.fherfurt.organization.resources;

import de.fherfurt.organization.core.models.Element;
import de.fherfurt.organization.storage.core.RepositoryFactory;
import de.fherfurt.organization.storage.repository.FaqRepositiory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

/**
 * Resource for Faq in the Rest API
 *
 * @see BaseResource
 * @author Felix Zwicker
 */
public class FaqResource {

    private final FaqRepositiory faqRepository;

    public FaqResource() {
        this.faqRepository = RepositoryFactory.getInstance().getFaqRepository();
    }

    /**
     * GET operation for all elements
     * @return list of all created elements
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Element> getAllElements(){
        return this.faqRepository.getAllElements();
    }

    /**
     * GET operation for specific element
     * @param elementId id of searched element
     * @return OK if found, NOT_FOUND if no element was found
     */
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

    /**
     *POST operation to create a new element
     * @param elementToCreate object of type element
     * @return Response OK if build was successful, INTERNAL_SERVER_ERROR if it couldnt be created
     */
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

    /**
     * PUT operation to update an element
     * @param elementToUpdate object of type element
     * @return Response - successful or not
     */
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

    /**
     * DELETE operation to delete an element
     * @param elementId id of element
     * @return Response - successful or not
     */
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