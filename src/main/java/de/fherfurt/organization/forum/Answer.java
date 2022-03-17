package de.fherfurt.organization.forum;

public class Answer {
    private Message message;

    public Answer(String title, String text, String author) {
        this.message = new Message(title, text, author);
    }

    public String getTitle() {
        return this.message.getTitle();
    }
}
