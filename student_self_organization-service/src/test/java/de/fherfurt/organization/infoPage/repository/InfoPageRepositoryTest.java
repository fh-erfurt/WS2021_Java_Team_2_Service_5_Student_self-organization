package de.fherfurt.organization.infoPage.repository;

import de.fherfurt.persons.client.DevPerson;
import de.fherfurt.persons.client.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfoPageRepositoryTest {
    private InfoPageRepository infoPageRepository;

    @BeforeEach
    void setup(){
        infoPageRepository = new InfoPageRepository();
        DevPerson devPerson = new DevPerson();
        infoPageRepository.addPersonToInfoPage(devPerson.getPersonById(1));
        infoPageRepository.addPersonToInfoPage(devPerson.getPersonById(2));
    }

    @Test
    void shouldAddPersonToInfoPage(){
        //Persons are stored in PersonClient DevPerson and just accessed not created
        //this testPerson was created only for testing
        Person testPerson = new Person("Felix","Zwicker","Student","6.02.13", "felix.zwicker@fh-erfurt.de","067234592",3);
        int expectedPersonListSize = 3;
        infoPageRepository.addPersonToInfoPage(testPerson);

        Assertions.assertEquals(expectedPersonListSize, infoPageRepository.getInfoPage().getPersonList().size());
    }

    @Test
    void shouldRemovePersonFromInfoPage(){
        int personId = 2;
        int expectedPersonListSize = 1;

        infoPageRepository.removePersonFromInfoPageById(personId);

        Assertions.assertEquals(expectedPersonListSize, infoPageRepository.getInfoPage().getPersonList().size());
    }

    @Test
    void tryToRemoveNotExistentPerson(){

    }

    @Test
    void shouldUpdateHeader(){
        String testHeader = "Gremien Informationen";

        infoPageRepository.updateHeader(testHeader);

        Assertions.assertEquals(testHeader, infoPageRepository.getInfoPage().getHeader());
    }

    @Test
    void shouldUpdateContent(){
        String testContent = "Allgemeine Informationen";

        infoPageRepository.updateContent(testContent);

        Assertions.assertEquals(testContent, infoPageRepository.getInfoPage().getContent());
    }
}