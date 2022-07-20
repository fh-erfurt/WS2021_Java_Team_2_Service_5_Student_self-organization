package de.fherfurt.organization.forum.core;

import de.fherfurt.organization.storage.core.AbstractDatabaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * represents a question in the forum and contains the answers and the topic
 *
 * @author Jenny Wagner
 */
@Entity
public class Question extends AbstractDatabaseEntity {
    @OneToOne
    private Message message;
    private String topic;
    @OneToMany
    private List<Answer> answers;

    public Question() {}

    public Question(String topic, String title, String text, String author) {
        this.message = new Message(title, text, author);
        this.topic = topic;
        this.answers = new ArrayList<>();
    }

    public void addAnswer (String title, String text, String author){
        this.answers.add(new Answer(title, text, author));
    }

    /**
     * removes an answer from this question
     *
     * @param title of the answer to delete
     * @return if the remove was success
     */
    public boolean removeAnswer (String title){
        for (Answer element : this.answers) {
            if(element.getTitle().equals(title)) {
                return true;
            }
        }
        
        return false;
    }

    public String getTitle() {
        return this.message.getTitle();
    }

    public String getAuthor () {
        return this.message.getAuthor();
    }

    public String getTopic() {
        return this.topic;
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }
}
