package de.fherfurt.organization.FAQ;

import java.time.LocalDateTime;
import java.util.Date;

public class Elements
{
    private String title;
    private String content;
    private Date date;
    private int elementId;

    public Elements(String title, String content, Date date, int elementId){
        this.title = title;
        this.content = content;
        this.date = date;
        this.elementId = elementId;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public void setDate(){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public void setElementId(){
        this.elementId = elementId;
    }

    public int getElementId(){
        return elementId;
    }


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
