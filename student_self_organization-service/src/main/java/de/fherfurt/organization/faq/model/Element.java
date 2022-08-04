package de.fherfurt.organization.faq.model;


import de.fherfurt.organization.storage.core.AbstractDatabaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Class carries all information of a FAQ-Element
 * Class represents and creates element for FAQ and puts them in the FaqRepository
 *
 * @author Felix Zwicker
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Element extends AbstractDatabaseEntity
{
    private String title;
    private String content;
    private String author;

    /**
     * Class using Builder pattern to help construct an Element of the FAQ
     * flexible in constructing an Element and easier for future updates
     */
    public static class Builder{
        private String title;
        private String content;
        private String author;

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

        /**
         * builds the object Element
         *
         * @return constructed Element
         */
        public Element build(){
            return new Element(title,content,author);
        }
    }

    /**
     * converts object to String
     * overriding toString method makes it easier to operate
     */
    @Override
    public String toString(){
        return "Title: " +title+", Content: "
                +content+", Author: "+author;
    }
}

