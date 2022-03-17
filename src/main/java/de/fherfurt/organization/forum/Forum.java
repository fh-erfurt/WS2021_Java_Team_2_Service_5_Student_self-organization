package de.fherfurt.organization.forum;

import java.util.ArrayList;

public class Forum {
    private ArrayList<String> topics;
    private ArrayList<Question> questions;

    public void addNewQuestion(String topic, String title, String text, String author){
        this.questions.add(new Question(topic, title, text, author));
    }

    public boolean removeQuestion(String title){
        for(int i = 0; i < this.questions.size(); i++){
            if(this.questions.get(i).getTitle().equals(title)){
                this.questions.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Question> getByTopic (String topic){
        ArrayList<Question> result = new ArrayList<>();

        if(isTopic(topic)) {
            for(int i = 0; i < this.questions.size(); i++) {
                if(this.questions.get(i).getTopic().equals(topic)) {
                    result.add(this.questions.get(i));
                }
            }
        }

        return result;
    }

    public ArrayList<Question> getByQuestionTitle (String question){

    }

    public ArrayList<Question> getByQuestionAuthor (String author){

    }

    public boolean addNewTopic (String newTopic){
        for(int i = 0; i < this.topics.size(); i++){
            if(this.topics.get(i).equals(newTopic)){
                return false;
            }
        }
        this.topics.add(newTopic);
        return true;
    }

    public boolean removeTopic (String topic){
        for(int i = 0; i < this.topics.size(); i++){
            if(this.topics.get(i).equals(topic)){
                this.topics.remove(i);
                return true;
            }
        }
        return false;
    }
}
