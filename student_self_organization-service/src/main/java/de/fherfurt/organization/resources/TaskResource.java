package de.fherfurt.organization.resources;

import de.fherfurt.organization.core.models.Task;
import de.fherfurt.organization.storage.core.RepositoryFactory;
import de.fherfurt.organization.storage.repository.TodoRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class TaskResource {

    private final TodoRepository todoRepository;

    public TaskResource() {
        this.todoRepository = RepositoryFactory.getInstance().getTodoRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) // using the json format for the application
    public List<Task> getAllTasks(){
        return this.todoRepository.getAllTasks();
    }

    @GET
    @Path("{taskId:\\d+}") // taskId is being used for getting a certain task
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTask(@PathParam("taskId") int taskId){
        Task task = this.todoRepository.getTask(taskId);

        if(task != null){
            return Response.ok(task).build(); // gives the task back as a response
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build(); // gives the response that the task couldn't be found (404)
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTask(Task taskToCreate){
        boolean success = this.todoRepository.createTask(taskToCreate);

        if(success){
            return Response.ok(taskToCreate).build();
        }
        else{
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(); // gives the response of an internal server error (500)
        }
    }

    @PUT
    @Path("{taskId:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTask(Task taskToUpdate){
        boolean success = this.todoRepository.updateTask(taskToUpdate);

        if(success){
            return Response.ok().build();
        }
        else{
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{taskId:\\d+}")
    public Response deleteTask(@PathParam("taskId") int taskId){
        Task task = this.todoRepository.getTask(taskId);

        if(task != null){
            this.todoRepository.deleteTask(taskId);
            return Response.ok().build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}

