package de.fherfurt.organization.storage.core;

import de.fherfurt.organization.core.enums.Priority;
import de.fherfurt.organization.core.models.Task;

import java.util.List;


public interface ITaskDao extends IGenericDao <Task>{

    List<Task> findTaskByChecked(boolean isChecked);

    List<Task> findTaskByPriority(Priority priority);

    List<Task> findTaskByUnchecked(boolean isChecked);
}
