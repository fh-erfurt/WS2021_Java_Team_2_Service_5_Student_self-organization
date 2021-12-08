package de.fherfurt.organization;

public class FormQuestions {

    private Topic topic;
    private String title;
    private String question;

    public void createForm (Topic topic, String title, String question) {
        this.topic = topic;
        this.title = title;
        this.question = question;
    }

    public void saveQuestion () {

    }

}
