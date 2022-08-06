package de.fherfurt.organization.client.forum;

import de.fherfurt.organization.models.Question;

import java.util.ArrayList;

/**
 * This Interface provides Forum questions from a certain topic
 * It could be used by other services
 *
 * @author Friedemann Taubert, Felix Zwicker
 */
public interface ForumClient {
    /**
     * This Methode will find questions
     * from the ArrayList Question by
     * the topic
     *
     * @param topic - needed for searching
     * @return ArrayList<Question> - with all its questions from the topic
     */
    ArrayList<Question> getByTopic (String topic);
}
