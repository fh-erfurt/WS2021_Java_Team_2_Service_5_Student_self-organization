package de.fherfurt.organization.storage.core;

import de.fherfurt.organization.core.enums.Priority;
import de.fherfurt.organization.core.models.Task;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class JpaTaskDao extends JpaGenericDao <Task> implements ITaskDao {

    public JpaTaskDao(EntityManager em) {
        super(Task.class, em);
    }

    public List<Task> findTaskByChecked(boolean isChecked)
    {
        return this.findAll()
                .stream()
                .filter( Task -> isChecked==Task.getIsChecked())
                .collect(Collectors.toList());
    }

    public List<Task> findTaskByPriority(Priority priority)
    {
        return this.findAll()
                .stream()
                .filter( Task -> priority.equals(Task.getPriority()))
                .collect(Collectors.toList());
    }
    public List<Task> findTaskByUnchecked(boolean isChecked)
    {
        return this.findAll()
                .stream()
                .filter( Task -> isChecked!=Task.getIsChecked())
                .collect(Collectors.toList());
    }
}
