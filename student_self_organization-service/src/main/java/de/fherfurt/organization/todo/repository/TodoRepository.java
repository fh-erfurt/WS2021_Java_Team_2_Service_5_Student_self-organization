package de.fherfurt.organization.todo.repository;

import de.fherfurt.organization.faq.core.errors.EntryNotFoundException;
import de.fherfurt.organization.todo.core.Task;

import java.util.LinkedList;
import java.util.List;

/**
 * Class representing Repository for all Tasks
 *
 * @author Tim Eisenberg, Maximilian Keller, Felix Zwicker
 */
public class TodoRepository {
    private final List<Task> todoList;

    /**
     * Constructor creating a new LinkedList to save created Tasks
     */
    public TodoRepository() {
        todoList = new LinkedList<>();
    }

    /**
     * adds Task to List
     * creates taskId for Task
     *
     * @param task declared Task
     * @see Task
     */
    public void addTask(Task task) {
        Task lastTaskInList;
        int lastTaskId;

        //get id from last Task in List and adds 1 to new Task
        if (todoList.size() != 0) {
            lastTaskInList = todoList.get(todoList.size() - 1);
            lastTaskId = lastTaskInList.getTaskId();
            task.setTaskId(lastTaskId + 1);
        }
        //when no object in list, id is set to 1
        else {
            task.setTaskId(1);
        }
        todoList.add(task);
    }

    /**
     * removes Task from List
     *
     * @param taskId ID of Task
     * @throws EntryNotFoundException when no object with searched ID exists
     * @see EntryNotFoundException
     */
    public void deleteTaskById(int taskId) throws EntryNotFoundException {
        todoList.remove(getTaskById(taskId));
    }

    /**
     * searches through the list by stream
     * and returns found Task
     *
     * @param taskId ID of searched Task
     * @return found Task
     * @throws EntryNotFoundException when no object with searched id exists
     * @see EntryNotFoundException
     */
    public Task getTaskById(int taskId) throws EntryNotFoundException {
        Task searchedTask = todoList.stream()
                .filter(Tasks -> taskId == Tasks.getTaskId())
                .findAny()
                .orElse(null);

        if (searchedTask == null) {
            throw new EntryNotFoundException("Task with ID: " + taskId + " couldn't be found");
        }
        return searchedTask;
    }

    public void check(int taskId) throws EntryNotFoundException {
        Task task = getTaskById(taskId);
        task.setIsChecked(true);
    }

    public void unCheck(int taskId) throws EntryNotFoundException {
        Task task = getTaskById(taskId);
        task.setIsChecked(false);
    }

    public List<Task> getTodoList() {
        return todoList;
    }

    public void clearTodoList() {
        todoList.clear();
    }

    public void printTodoList() {
        System.out.println(todoList);
    }
}
