package de.fherfurt.organization.faq.core;

import java.time.LocalDate;

/**
 * Class carries all informations of a FAQ-Element
 * Class represents and creats elements for FAQ and puts them in the FaqRepository
 *
 * @author Felix Zwicker
 */

public class Elements
{
    private String title;
    private String content;
    private String author;
    private LocalDate date;
    private int elementId;

    private Elements(){}

    /**
     * Constructor
     *
      * @param builder uses Builder class to construct
     */
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

    /**
     * Class using Builder pattern to help construct the Elements of the FAQ
     * flexible in constructing Elements and easier for future updates
     */
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

        /**
         * builds the object Element
         * @return Elements constructed Element
         */
        public Elements build(){
            return new Elements(this);
        }

    }

    /**
     * converts object to String
     * overriding toString method makes it easier to operate
     */
    @Override
    public String toString(){
        return "Title: " +title+", Content: "
                +content+", Author: "+author+", Date: "+date+", id: "+elementId;
    }
}

