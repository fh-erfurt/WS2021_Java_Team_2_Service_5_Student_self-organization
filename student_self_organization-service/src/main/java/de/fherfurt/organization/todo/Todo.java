package de.fherfurt.organization.todo;

import java.util.LinkedList;
import java.util.List;


public class Todo {
    private List<Task> todoList;

    Todo(){
        todoList = new LinkedList<>();
    }

    public void addElement(Task element){
        todoList.add(element);
    }

    public Task searchElement(int elementId) {
        Task searchedElement = todoList.stream()
                .filter(Elements -> elementId == Elements.getElementId()).findAny().orElse(null);

        return searchedElement;
    }

    public void deleteElement(int elementId){
        todoList.remove(searchElement(elementId));

    }

    public void deleteAllElements(){
        todoList.clear();
    }


    public void printTodoList(){
        System.out.println(todoList);
    }
}
