package de.fherfurt.organization.core.models;

import de.fherfurt.organization.storage.core.AbstractDatabaseEntity;
import de.fherfurt.organization.core.enums.Priority;

import javax.persistence.Entity;

/**
 * Class carries all information of a Todo-Task
 * Class represents and creates element for Todo and puts them in the Todo class
 *
 * @author Tim Eisenberg, Maximilian Keller, Felix Zwicker
 */
@Entity
public class Task extends AbstractDatabaseEntity//StorageEntity
{
    public Task() {}
    private String title;

    private boolean isChecked;
    private Priority priority;

    private Task(String title, boolean isChecked, Priority priority) {
        this.title = title;
        this.isChecked = isChecked;
        this.priority = priority;
    }

    //Setter
    public void setTitle(String title){
        this.title = title;
    }


    public void setIsChecked(boolean isChecked){
        this.isChecked = isChecked;
    }


    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    //Getter
    public String getTitle(){
        return title;
    }

    public boolean getIsChecked(){
        return isChecked;
    }

    public Priority getPriority(){
        return priority;
    }

    /**
     * Class using Builder pattern to help construct a Task of the Todo
     * flexible in constructing a Task and easier for future updates
     */

    public static class Builder{
        private String title;
        private boolean isChecked;
        private Priority priority;

        public Builder(){}
        public Builder withTitle(String title){
            this.title = title;
            return this;
        }

        public Builder withIsChecked(boolean isChecked){
            this.isChecked = isChecked;
            return this;
        }

        public Builder withPriority(Priority priority){
            this.priority = priority;
            return this;
        }

        /**
         * builds the object Task
         *
         * @return constructed Task
         */
        public Task build(){
            return new Task(title,isChecked,priority);
        }
    }

    /**
     * converts object to String
     * overriding toString method makes it easier to operate
     */

    @Override
    public String toString(){
        return "Title: " +title+", Checked: "+isChecked+", Priority: "+priority;
    }

    /**
     public void check(int taskId) throws EntryNotFoundException {
     Task task = getTaskById(taskId);
     task.setIsChecked(true);
     }

     public void unCheck(int taskId) throws EntryNotFoundException {
     Task task = getTaskById(taskId);
     task.setIsChecked(false);
     }
     */
}

