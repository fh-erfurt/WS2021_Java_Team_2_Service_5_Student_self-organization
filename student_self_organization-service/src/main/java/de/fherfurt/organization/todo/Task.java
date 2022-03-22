package de.fherfurt.organization.todo;

import java.time.LocalDateTime;

/**
 *
 *
 */

public class Task
{
    private String title;
    private LocalDateTime deadline;
    private LocalDateTime alarm;
    private int elementId;
    private boolean isChecked;

    private Task(){}
    private Task(Builder builder){
        this.title = builder.title;
        this.deadline = builder.deadline;
        this.alarm = builder.alarm;
        this.elementId = builder.elementId;
        this.isChecked = builder.isChecked;
    }

    //Setter
    public void setTitle(String title){
        this.title = title;
    }

    public void setDeadline(LocalDateTime deadline){
        this.deadline = deadline;
    }

    public void setAlarm(LocalDateTime alarm){
        this.alarm = alarm;
    }

    public void setElementId(int elementId){
        this.elementId = elementId;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    //Getter
    public String getTitle(){
        return title;
    }

    public LocalDateTime getDeadline(){
        return deadline;
    }

    public LocalDateTime getAlarm() {
        return alarm;
    }

    public int getElementId(){
        return elementId;
    }

    public boolean getIsChecked(){
        return isChecked;
    }

    public static class Builder{
        private String title;
        private LocalDateTime deadline;
        private LocalDateTime alarm;
        private int elementId;
        private boolean isChecked;
        public Builder(){}
        public Builder withTitle(String title){
            this.title = title;
            return this;
        }
        public Builder withDeadline(LocalDateTime deadline){
            this.deadline = deadline;
            return this;
        }
        public Builder withAlarm(LocalDateTime alarm){
            this.alarm = alarm;
            return this;
        }
        public Builder withElementId(int elementId){
            this.elementId = elementId;
            return this;
        }
        public Builder withIsChecked(boolean isChecked){
            this.isChecked = isChecked;
            return this;
        }
        public Task build(){
            return new Task(this);
        }

    }

    @Override
    public String toString(){
        return "task: " +title+", Deadline: "+deadline+", id: "+elementId+ "checked: " + isChecked;
    }
}
