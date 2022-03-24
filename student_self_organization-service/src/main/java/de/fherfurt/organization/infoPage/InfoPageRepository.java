package de.fherfurt.organization.infoPage;

import de.fherfurt.persons.client.Person;

import java.util.LinkedList;
import java.util.List;

/**
 * Class representing InfoPage Repository
 *
 * @author Felix Zwicker
 */
public class InfoPageRepository {
    private final InfoPage infoPage;
    private List<Person> personsList;

    InfoPageRepository() {
        personsList = new LinkedList<>();
        infoPage = new InfoPage("", "", personsList);
    }

    /**
     * adds Person to personList in object InfoPage
     *
     * @param person created Person from Person-Client
     * @see InfoPage
     * @see Person
     */
    public void addPersonToInfoPage(Person person) {
        //get personList of object
        personsList = infoPage.getPersonList();
        //set new Person
        personsList.add(person);
    }

    /**
     * removes Person from personList on object InfoPage
     *
     * @param personId id of needed person
     */
    public void removePersonFromInfoPageById(int personId) {
        //get personList of object
        personsList = infoPage.getPersonList();
        //search for person by id in list
        Person searchedPerson = personsList.stream()
                .filter(Person -> personId == Person.getPersonId()).findAny().orElse(null);
        //remove found person
        personsList.remove(searchedPerson);
    }

    public void updateHeader(String header) {
        infoPage.setHeader(header);
    }

    public void updateContent(String content) {
        infoPage.setContent(content);
    }

    public InfoPage getInfoPage() {
        return infoPage;
    }

    public void showInfoPage() {
        System.out.println(infoPage);
    }
}