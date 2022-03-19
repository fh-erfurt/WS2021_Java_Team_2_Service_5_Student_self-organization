package de.fherfurt.persons.client;

public class Person {
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String room;
    private String email;
    private String phonenumber;

    public Person(String firstName, String lastName, String jobTitle, String room, String email, String phonenumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.room = room;
        this.email = email;
        this.phonenumber = phonenumber;
    }

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

    public String getPhonenumber(){
        return phonenumber;
    }
}
