package de.fherfurt.organization.forum.core;

import de.fherfurt.organization.storage.core.AbstractDatabaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * represents an answer to a forum question
 *
 * @author Jenny Wagner
 */
@Entity
public class Answer extends AbstractDatabaseEntity {
    @OneToOne
    private Message message;

    public Answer() {}

    public Answer(String title, String text, String author) {
        this.message = new Message(title, text, author);
    }

    public String getTitle() {
        return this.message.getTitle();
    }
}