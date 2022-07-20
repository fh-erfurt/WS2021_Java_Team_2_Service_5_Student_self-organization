package de.fherfurt.organization.forum.core;

import de.fherfurt.organization.storage.core.AbstractDatabaseEntity;

import javax.persistence.Entity;

/**
 * is a data container for a basic message
 *
 * @author Jenny Wagner
 */
@Entity
public class Message extends AbstractDatabaseEntity {
    private String title;
    private String text;
    private String author;

    public Message() {}

    public Message(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
