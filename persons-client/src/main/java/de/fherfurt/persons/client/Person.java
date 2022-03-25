package de.fherfurt.persons.client;

/**
 * Class representing and creating a Person
 */
public class Person {
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String room;
    private String email;
    private String phoneNumber;
    private int personId;

    public Person(String firstName, String lastName, String jobTitle, String room, String email, String phoneNumber, int personId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.room = room;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.personId = personId;
    }

    //Setter
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setPersonId(int personId){
        this.personId = personId;
    }

    //Getter
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getJobTitle(){
        return jobTitle;
    }

    public String getRoom(){
        return room;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public int getPersonId(){
        return personId;
    }
}
