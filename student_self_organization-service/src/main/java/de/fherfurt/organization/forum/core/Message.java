package de.fherfurt.organization.forum.core;

/**
 * is a data container for a basic message
 *
 * @author Jenny Wagner
 */
public class Message {
    private String title;
    private String text;
    private String author;

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
