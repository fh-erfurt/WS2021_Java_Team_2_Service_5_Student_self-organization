package de.fherfurt.organization.todo;

import de.fherfurt.organization.todo.Todo;
import de.fherfurt.organization.faq.core.errors.EntryNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TodoTest {
    private Todo todoRepo;
    Task firstTask = new Task.Builder().withTitle("Semester Rückmeldung").withSelfDeclaredDate(2022,4, 1 ).withIsChecked(true).withPriority(Priority.IMPORTANT).build();
    Task secondTask = new Task.Builder().withTitle("Bafög").withSelfDeclaredDate(2022,5,3).withIsChecked(false).withPriority(Priority.HIGHLY_IMPORTANT).build();
    Task thirdTask = new Task.Builder().withTitle("Klausuranmeldung").withSelfDeclaredDate(2022,7,12).withIsChecked(false).withPriority(Priority.INSIGNIFICANT).build();

    @BeforeEach
    void setupTodo(){
        todoRepo = new Todo();
        todoRepo.addTask(firstTask);
        todoRepo.addTask(secondTask);
        todoRepo.addTask(thirdTask);
    }

    @AfterEach
    void deleteTodo(){
        todoRepo.clearTodoList();
    }

    @Test
    void shouldRemoveTask(){
        int taskTestIdToRemove = 3;

        Assertions.assertDoesNotThrow(() -> todoRepo.deleteTaskById(taskTestIdToRemove));
    }

    @Test
    void tryToRemoveNotExistentTask(){
        int taskTestIdToRemove = 4;

        Assertions.assertThrows(EntryNotFoundException.class,() -> todoRepo.deleteTaskById(taskTestIdToRemove));
    }

    @Test
    void shouldGetTasksById(){
        int taskTestId = 2;

        Assertions.assertEquals(taskTestId , secondTask.getTaskId());
    }

    @Test
    void tryToGetNotExistentTask(){
        int taskTestId = 4;

        Assertions.assertThrows(EntryNotFoundException.class,() -> todoRepo.getTaskById(taskTestId));
    }
    @Test
    void checkTest() throws EntryNotFoundException {
        Task testTask = secondTask;
        todoRepo.check(2);
        Assertions.assertNotEquals(secondTask, testTask);
    }

    @Test
    void unCheck() throws EntryNotFoundException {
        Task testTask = firstTask;
        todoRepo.unCheck(1);
        Assertions.assertEquals(firstTask, testTask);
    }

    /**
     * testing toString
     *
     * @see Task
     */
    @Test
    void printTodoListToString(){
        todoRepo.printTodoList();
    }
}