package de.fherfurt.organization.infoPage.core;

import de.fherfurt.persons.client.Person;

import java.util.List;

/**
 * Class representing and creating the InfoPage
 *
 * @author Felix Zwicker
 */
public class InfoPage {
    private String header;
    private String content;
    private List<Person> personList;

    public InfoPage(String header, String content, List<Person> personList){
        this.header = header;
        this.content = content;
        this.personList = personList;
    }

    //Setter
    public void setContent(String content){
        this.content = content;
    }

    public void setHeader(String header){
        this.header = header;
    }

    public void setPersonList(List<Person> persons){
        this.personList = persons;
    }

    //Getter
    public String getContent(){
        return content;
    }

    public String getHeader(){
        return header;
    }

    public List<Person> getPersonList(){
        return personList;
    }

    /**
     * converts object to String
     * overriding toString method makes it easier to operate
     */
    @Override
    public String toString(){
        return "Title: " +header+" Content: "
                +content+" Persons: "+personList;
    }

}
