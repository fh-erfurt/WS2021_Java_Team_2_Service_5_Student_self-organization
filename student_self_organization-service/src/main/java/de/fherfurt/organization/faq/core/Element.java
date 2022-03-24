package de.fherfurt.organization.faq.core;

import java.time.LocalDate;

/**
 * Class carries all information of a FAQ-Element
 * Class represents and creates element for FAQ and puts them in the FaqRepository
 *
 * @author Felix Zwicker
 */
public class Element
{
    private String title;
    private String content;
    private String author;
    private LocalDate date;
    private int elementId;

    private Element(){}
    private Element(String title, String content, String author, LocalDate date, int elementId) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.elementId = elementId;
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
     * Class using Builder pattern to help construct an Element of the FAQ
     * flexible in constructing an Element and easier for future updates
     */
    public static class Builder{
        private String title;
        private String content;
        private String author;
        private LocalDate date;

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

        /**
         * allows building Element with self-declared Date
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
         * builds the object Element
         *
         * @return constructed Element
         */
        public Element build(){
            return new Element(title,content,author,date,0);
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

