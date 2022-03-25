package de.fherfurt.organization.todo.repository;

import de.fherfurt.organization.faq.core.errors.EntryNotFoundException;
import de.fherfurt.organization.todo.core.Priority;
import de.fherfurt.organization.todo.core.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TodoRepositoryTest {
    private TodoRepository todoRepositoryRepo;
    Task firstTask = new Task.Builder().withTitle("Semester Rückmeldung").withSelfDeclaredDate(2022,4, 1 ).withIsChecked(true).withPriority(Priority.IMPORTANT).build();
    Task secondTask = new Task.Builder().withTitle("Bafög").withSelfDeclaredDate(2022,5,3).withIsChecked(false).withPriority(Priority.HIGHLY_IMPORTANT).build();
    Task thirdTask = new Task.Builder().withTitle("Klausuranmeldung").withSelfDeclaredDate(2022,7,12).withIsChecked(false).withPriority(Priority.INSIGNIFICANT).build();

    @BeforeEach
    void setupTodo(){
        todoRepositoryRepo = new TodoRepository();
        todoRepositoryRepo.addTask(firstTask);
        todoRepositoryRepo.addTask(secondTask);
        todoRepositoryRepo.addTask(thirdTask);
    }

    @AfterEach
    void deleteTodo(){
        todoRepositoryRepo.clearTodoList();
    }

    @Test
    void shouldRemoveTask(){
        int taskTestIdToRemove = 3;

        Assertions.assertDoesNotThrow(() -> todoRepositoryRepo.deleteTaskById(taskTestIdToRemove));
    }

    @Test
    void tryToRemoveNotExistentTask(){
        int taskTestIdToRemove = 4;

        Assertions.assertThrows(EntryNotFoundException.class,() -> todoRepositoryRepo.deleteTaskById(taskTestIdToRemove));
    }

    @Test
    void shouldGetTasksById(){
        int taskTestId = 2;

        Assertions.assertEquals(taskTestId , secondTask.getTaskId());
    }

    @Test
    void tryToGetNotExistentTask(){
        int taskTestId = 4;

        Assertions.assertThrows(EntryNotFoundException.class,() -> todoRepositoryRepo.getTaskById(taskTestId));
    }

    @Test
    void checkTest() throws EntryNotFoundException {
        Task testTask = new Task.Builder().withTitle("Bafög").withSelfDeclaredDate(2022,5,3).withIsChecked(false).withPriority(Priority.HIGHLY_IMPORTANT).build();
        todoRepositoryRepo.check(2);

        Assertions.assertNotEquals(todoRepositoryRepo.getTaskById(2), testTask);
    }

    @Test
    void unCheck() throws EntryNotFoundException {
        Task testTask = new Task.Builder().withTitle("Semester Rückmeldung").withSelfDeclaredDate(2022,4, 1 ).withIsChecked(true).withPriority(Priority.IMPORTANT).build();
        todoRepositoryRepo.unCheck(1);

        Assertions.assertNotEquals(firstTask, testTask);
    }

    /**
     * testing toString
     *
     * @see Task
     */
    @Test
    void printTodoListToString(){
        todoRepositoryRepo.printTodoList();
    }
}