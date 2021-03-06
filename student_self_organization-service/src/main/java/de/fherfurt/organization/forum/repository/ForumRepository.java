package de.fherfurt.organization.forum.repository;

import de.fherfurt.organization.forum.core.Question;

import java.util.ArrayList;

/**
 * in Forum you can add new questions, delete questions,
 * find a certain topic by its name, find a question by its name
 * find a question by its author, add a new topic or remove
 * an existing topic
 *
 * @author Friedemann Taubert
 */
public class ForumRepository {
    private final ArrayList<String> topics;
    private final ArrayList<Question> questions;

    public ForumRepository() {
        this.topics = new ArrayList<>();
        this.questions = new ArrayList<>();
    }

    public void addNewQuestion(String topic, String title, String text, String author) {
        this.questions.add(new Question(topic, title, text, author));
    }

    /**
     * it removes a certain question from the question list
     *
     * @param title it's the title of the question that we want to remove
     * @return returns false, if the name isn't found
     * deletes the questions and returns true, if we found the title
     */
    public boolean removeQuestion(String title) {
        for (Question question : this.questions) {
            if (question.getTitle().equals(title)) {
                this.questions.remove(question);
                return true;
            }
        }

        return false;
    }

    /**
     * it gets the questions of a certain topic
     *
     * @param topic it's the topic of which the questions should be shown
     * @return returns an array list of questions, if the topic and questions to it exist
     * returns an empty list, if no questions were found or the given topic
     * doesn't exist
     */
    public ArrayList<Question> getByTopic(String topic) {
        ArrayList<Question> result = new ArrayList<>();

        if (isTopic(topic)) {
            for (Question question : this.questions) {
                if (question.getTopic().equals(topic)) {
                    result.add(question);
                }
            }
        }

        return result;
    }

    /**
     * checks, if a given topic exists
     *
     * @param topic is the name of the topic to check
     * @return true, if the topic exists
     * false, if it doesn't
     */
    public boolean isTopic(String topic) {
        for (String s : this.topics) {
            if (s.equals(topic)) {
                return true;
            }
        }
        return false;
    }

    /**
     * it gets the questions of a certain title
     *
     * @param question it's the title of which the questions should be shown
     * @return returns an array list of questions, if the title to it exist
     * returns an empty list, if no questions were found or the given title
     * doesn't exist
     */
    public ArrayList<Question> getByQuestionTitle(String question) {
        ArrayList<Question> result = new ArrayList<>();

        for (Question value : this.questions) {
            if (value.getTitle().equals(question)) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * it gets the questions from a certain author
     *
     * @param author it's the author of which the questions should be shown
     * @return returns an array list of questions, if the author exist
     * returns an empty list, if the author wasn't found or if there are
     * no questions found
     */
    public ArrayList<Question> getByQuestionAuthor(String author) {
        ArrayList<Question> result = new ArrayList<>();

        for (Question question : this.questions) {
            if (question.getAuthor().equals(author)) {
                result.add(question);
            }
        }

        return result;
    }

    /**
     * it adds a new topic
     *
     * @param newTopic is the name of the new topic
     * @return false, if there already exists a topic with the same name
     * creates a new topic and returns true, if the topic doesn't exist yet
     */
    public boolean addNewTopic(String newTopic) {
        for (String topic : this.topics) {
            if (topic.equals(newTopic)) {
                return false;
            }
        }
        this.topics.add(newTopic);
        return true;
    }

    /**
     * it removes an existing topic
     *
     * @param topic is the name of the topic we want to have removed
     * @return false, if the topic we want to remove doesn't exist
     * removes the topic and returns true, if we found that topic
     */
    public boolean removeTopic(String topic) {

        for (String name : this.topics) {
            if (name.equals(topic)) {
                this.topics.remove(topic);
                return true;
            }
        }

        return false;
    }
}
