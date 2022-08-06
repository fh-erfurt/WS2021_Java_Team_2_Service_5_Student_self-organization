package de.fherfurt.organization.storage.repository;

import de.fherfurt.organization.core.enums.Priority;
import de.fherfurt.organization.core.models.Task;

import java.util.List;

public interface TodoRepository {

    List<Task> getAllTasks();

    Task getTask(int taskId);

    boolean deleteTask(int taskId);

    boolean createTask(Task task);

    boolean updateTask(Task task);

    List<Task> getTaskByChecked(boolean isChecked);

    List<Task> getTaskByPriority(Priority priority);

    List<Task> getTaskByUnchecked(boolean isChecked);
}
