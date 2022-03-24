package de.fherfurt.persons.client;

import java.util.LinkedList;
import java.util.List;

/**
 * Class containing list with created Persons
 * used to get Persons
 */
public class DevPerson implements PersonsClient{
    List<Person> personList;

    public DevPerson(){
        personList = new LinkedList<>();
        personList.add(new Person("Max","Mustermann","Studentenberatung","6.0.15","Max.Mustermann@fh-erfurt.de","0123456789",1));
        personList.add(new Person("Sabine","Musterfrau","Gremien Leitung","6.0.12","sabine-musterfrau@fh-erfurt.de","0132435465",2));
    }

    public Person getPersonById(int id){
        return personList.stream()
                .filter(Elements -> id == Elements.getPersonId()).findAny().orElse(null);
    }

    @Override
    public Person findPersonUsingIteratorBy(int PersonID){
        return null;
    }

    @Override
    public byte[] findPersonAvatarBy(int PersonID){
        return new byte[0];
    }
}
