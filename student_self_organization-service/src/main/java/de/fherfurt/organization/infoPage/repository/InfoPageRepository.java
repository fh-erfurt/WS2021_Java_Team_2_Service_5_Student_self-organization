package de.fherfurt.organization.infoPage.repository;

import de.fherfurt.organization.infoPage.core.InfoPage;
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

    public InfoPageRepository() {
        personsList = new LinkedList<>();
        //currently, only one InfoPage is needed
        //therefore it is declared directly
        infoPage = new InfoPage("", "", personsList);
    }

    /**
     * adds Person to personList in object InfoPage
     *
     * Persons are declared in DevPerson from Person-Client
     * and accessed through id
     *
     * @param person - Person from Person-Client
     * @see Person
     * @see de.fherfurt.persons.client.DevPerson
     */
    public void addPersonToInfoPage(Person person) {
        //get personList of object
        personsList = infoPage.getPersonList();
        //set new Person
        personsList.add(person);
    }

    /**
     * removes Person from personList in object InfoPage
     *
     * @param personId - ID of needed person
     */
    public void removePersonFromInfoPageById(int personId) {
        //get personList of object
        personsList = infoPage.getPersonList();
        //search for person by id in list
        Person searchedPerson = personsList.stream()
                .filter(Person -> personId == Person.getPersonId())
                .findAny()
                .orElse(null);
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