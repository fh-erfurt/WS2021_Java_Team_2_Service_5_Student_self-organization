package de.fherfurt.organization.faq.repository;

import de.fherfurt.organization.faq.core.*;
import de.fherfurt.organization.faq.core.enums.SortDirection;
import de.fherfurt.organization.faq.core.enums.SortPriority;
import de.fherfurt.organization.faq.core.errors.EntryNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


class FaqRepositoryTest {
    private FaqRepository faqRepo;
    Element firstElement = new Element.Builder().withTitle("Semester Rückmeldung").withContent("beispiel text").withAuthor("Felix Zwicker").withDate().build();
    Element secondElement = new Element.Builder().withTitle("Bafög").withContent("bafög antwort").withAuthor("Felix Zwicker").withDate().build();
    Element thirdElement = new Element.Builder().withTitle("Gremien").withContent("gremien antwort").withAuthor("Max Mustermann").withDate().build();

    @BeforeEach
    void setupFaq(){
        faqRepo = new FaqRepository();
        faqRepo.addElement(firstElement);
        faqRepo.addElement(secondElement);
        faqRepo.addElement(thirdElement);
    }

    @AfterEach
    void deleteFaq(){
        faqRepo.clearFaqList();
    }

    @Test
    void shouldRemoveElement(){
        int elementTestIdToRemove = 3;

        Assertions.assertDoesNotThrow(() -> faqRepo.deleteElementById(elementTestIdToRemove));
    }

    @Test
    void tryToRemoveNotExistentElement(){
        int elementTestIdToRemove = 4;

        Assertions.assertThrows(EntryNotFoundException.class,() -> faqRepo.deleteElementById(elementTestIdToRemove));
    }

    @Test
    void shouldGetElementsById(){
        int elementTestId = 2;

        Assertions.assertEquals(elementTestId , secondElement.getElementId());
    }

    @Test
    void tryToGetNotExistentElement(){
        int elementTestId = 4;

        Assertions.assertThrows(EntryNotFoundException.class,() -> faqRepo.getElementById(elementTestId));
    }

    @Test
    void shouldGetFaqElementsWithSameAuthor() throws EntryNotFoundException{
        String searchedTestAuthor = "Felix Zwicker";
        int expectedSizeOfFoundElements = 2;

        Assertions.assertDoesNotThrow(() -> faqRepo.getElementsByAuthor(searchedTestAuthor));
        Assertions.assertEquals(expectedSizeOfFoundElements ,faqRepo.getElementsByAuthor(searchedTestAuthor).size());
    }

    @Test
    void tryToGetFaqElementsWithNotExistentAuthor(){
        String searchedTestAuthor = "Silke Musterfrau";

        Assertions.assertThrows(EntryNotFoundException.class,() -> faqRepo.getElementsByAuthor(searchedTestAuthor));
    }

    @Test
    void shouldSortAscByTitle(){
        //creating list with expected order of objects
        List<Element> expectedOrder = new LinkedList<>();
        expectedOrder.add(secondElement);
        expectedOrder.add(thirdElement);
        expectedOrder.add(firstElement);

        //declaring sort order
        SortSettings sortSettings = new SortSettings(SortDirection.ASC, SortPriority.TITLE);
        faqRepo.sortList(sortSettings);

        Assertions.assertEquals(expectedOrder,faqRepo.getFaqList());
    }

    @Test
    void shouldSortDescByTitle(){
        //creating list with expected order of objects
        List<Element> expectedOrder = new LinkedList<>();
        expectedOrder.add(firstElement);
        expectedOrder.add(thirdElement);
        expectedOrder.add(secondElement);

        //declaring sort order
        SortSettings sortSettings = new SortSettings(SortDirection.DESC, SortPriority.TITLE);
        faqRepo.sortList(sortSettings);

        Assertions.assertEquals(expectedOrder,faqRepo.getFaqList());
    }

    @Test
    void shouldSortAscByDate(){
        //creating list for expected order of objects
        List<Element> expectedOrder = new LinkedList<>();
        //test Repository
        FaqRepository faqRepository = new FaqRepository();
        //testElement with self-declared Date
        Element testElement = new Element.Builder().withTitle("Test Title").withContent("Test Content")
                .withAuthor("Felix Zwicker").withSelfDeclaredDate(2021,11,15).build();
        //fill lists
        expectedOrder.add(testElement);
        expectedOrder.add(firstElement);
        faqRepository.addElement(firstElement);
        faqRepository.addElement(testElement);

        //declaring sort order
        SortSettings sortSettings = new SortSettings(SortDirection.ASC, SortPriority.DATE);
        faqRepository.sortList(sortSettings);

        Assertions.assertEquals(expectedOrder, faqRepository.getFaqList());

    }

    @Test
    void shouldSortDescByDate(){
        //creating list for expected order of objects
        List<Element> expectedOrder = new LinkedList<>();
        //test Repository
        FaqRepository faqRepository = new FaqRepository();
        //testElement with self-declared Date
        Element testElement = new Element.Builder().withTitle("Test Title").withContent("Test Content")
                .withAuthor("Felix Zwicker").withSelfDeclaredDate(2021,11,15).build();
        //fill lists
        expectedOrder.add(firstElement);
        expectedOrder.add(testElement);
        faqRepository.addElement(testElement);
        faqRepository.addElement(firstElement);

        //declaring sort order
        SortSettings sortSettings = new SortSettings(SortDirection.DESC, SortPriority.DATE);
        faqRepository.sortList(sortSettings);

        Assertions.assertEquals(expectedOrder, faqRepository.getFaqList());
    }

    @Test
    void shouldSortDescById() {
        //creating list with expected order of objects
        List<Element> expectedOrder = new LinkedList<>();
        expectedOrder.add(thirdElement);
        expectedOrder.add(secondElement);
        expectedOrder.add(firstElement);

        //declaring sort order
        SortSettings sortSettings = new SortSettings(SortDirection.DESC, SortPriority.ID);
        faqRepo.sortList(sortSettings);

        Assertions.assertEquals(expectedOrder, faqRepo.getFaqList());
    }

    /**
     * testing toString
     *
     * @see Element
     */
    @Test
    void printFaqListToString(){
        faqRepo.printFaqList();
    }
}