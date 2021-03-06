package de.fherfurt.organization.todo.core;

import java.time.LocalDate;

/**
 * Class carries all information of a Todo-Task
 * Class represents and creates element for Todo and puts them in the Todo class
 *
 * @author Tim Eisenberg, Maximilian Keller, Felix Zwicker
 */
public class Task
{
    private String title;
    private LocalDate date;
    private boolean isChecked;
    private int taskId;
    private Priority priority;

    private Task(String title, LocalDate date, boolean isChecked, int taskId, Priority priority) {
        this.title = title;
        this.date = date;
        this.isChecked = isChecked;
        this.taskId = taskId;
        this.priority = priority;
    }

    //Setter
    public void setTitle(String title){
        this.title = title;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setIsChecked(boolean isChecked){
        this.isChecked = isChecked;
    }

    public void setTaskId(int taskId){
        this.taskId = taskId;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    //Getter
    public String getTitle(){
        return title;
    }

    public LocalDate getDate(){
        return date;
    }

    public boolean getIsChecked(){
        return isChecked;
    }

    public int getTaskId(){
        return taskId;
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
        private LocalDate date;
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
         * allows building Tasks with self-declared Date
         *
         * @param year - Date year
         * @param month - Date month
         * @param day - Date day
         */

        public Builder withSelfDeclaredDate(int year, int month, int day){
            this.date = LocalDate.of(year,month,day);
            return this;
        }

        /**
         * builds the object Task
         *
         * @return constructed Task
         */
        public Task build(){
            return new Task(title,date,isChecked,0,priority);
        }
    }

    /**
     * converts object to String
     * overriding toString method makes it easier to operate
     */
    @Override
    public String toString(){
        return "Title: " +title+", Date: "
                +date+", Checked: "+isChecked+", id: "+taskId+" Priority: "+priority;
    }
}

