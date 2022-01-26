package de.fherfurt.organization;

import java.time.LocalDateTime;

public class CreateQuestion
{
    private String Question;

    private Topic topic = Topic.Fragen;
    private enum Topic{Corona, PraesenzMassnahmen, Fragen}

    //private int Length
    //private int FAQArray[];
    private LocalDateTime dateQuestionCreated;
    /*
    public void Create(String Question,String Topic, int Length)
    {
       int FAQArray[Length];
    }
    */
    public String getQuestion()
    {
        return Question;
    }

    public Topic getTopic()
    {
        return topic;
    }

    public LocalDateTime getQuestionCreatedDate()
    {
        return dateQuestionCreated;
    }

    public void setQuestion(String NewQuestion)
    {
        this.Question = NewQuestion;
    }

    public void setNewTopic (Topic NewTopic)
    {
        this.topic = NewTopic;
    }

}
