package de.fherfurt.organization.forum;

/**
 * It represents a new question in the forum
 * @author Wagner Jenny
 */
public class FormQuestions {

    private Topic topic;
    private String title;
    private String question;

    /**
     * It creates a new question form
     * @param topic It represents the topic of the question
     * @param title Title of the question
     * @param question  question text itself
     */
    public void createForm (Topic topic, String title, String question) {
        this.topic = topic;
        this.title = title;
        this.question = question;
    }

    public void saveQuestion () {

    }

}
