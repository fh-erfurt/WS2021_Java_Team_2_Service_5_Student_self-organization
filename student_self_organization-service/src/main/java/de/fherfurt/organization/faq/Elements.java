package de.fherfurt.organization.faq;

import java.time.LocalDate;

/**
 * carries all informations of a FAQ-Element
 *
 */

public class Elements
{
    private String title;
    private String content;
    private String author;
    private LocalDate date;
    private int elementId;

    private Elements(){}
    private Elements(Builder builder){
        this.title = builder.title;
        this.content = builder.content;
        this.author = builder.author;
        this.date = builder.date;
        this.elementId = builder.elementId;
    }

    //Setter
    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setElementId(int elementId){
        this.elementId = elementId;
    }

    //Getter
    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public LocalDate getDate(){
        return date;
    }

    public String getAuthor(){
        return author;
    }

    public int getElementId(){
        return elementId;
    }

    public static class Builder{
        private String title;
        private String content;
        private String author;
        private LocalDate date;
        private int elementId;
        public Builder(){}
        public Builder withTitle(String title){
            this.title = title;
            return this;
        }
        public Builder withContent(String content){
            this.content = content;
            return this;
        }
        public Builder withAuthor(String author){
            this.author = author;
            return this;
        }
        public Builder withDate(){
            this.date = LocalDate.now();
            return this;
        }
        public Builder withElementId(int elementId){
            this.elementId = elementId;
            return this;
        }
        public Elements build(){
            return new Elements(this);
        }

    }

    @Override
    public String toString(){
        return "Title: " +title+", Content: "
                +content+", Author: "+author+", Date: "+date+", id: "+elementId;
    }
}

