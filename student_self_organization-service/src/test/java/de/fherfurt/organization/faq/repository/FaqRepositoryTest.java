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

        Assertions.assertDoesNotThrow(() -> faqRepo.getElementsByAuthorUsingIterator(searchedTestAuthor));
        Assertions.assertEquals(expectedSizeOfFoundElements ,faqRepo.getElementsByAuthorUsingIterator(searchedTestAuthor));
    }

    @Test
    void tryToGetFaqElementsWithNotExistentAuthor(){
        String searchedTestAuthor = "Silke Musterfrau";

        Assertions.assertThrows(EntryNotFoundException.class,() -> faqRepo.getElementsByAuthorUsingIterator(searchedTestAuthor));
    }

    @Test
    void shouldSortAscByTitle(){
        List<Element> expectedOrder = new LinkedList<>();
        expectedOrder.add(secondElement);
        expectedOrder.add(thirdElement);
        expectedOrder.add(firstElement);

        SortSettings sortSettings = new SortSettings(SortDirection.ASC, SortPriority.TITLE);
        faqRepo.sortList(sortSettings);

        Assertions.assertEquals(expectedOrder,faqRepo.getFaqList());
    }

    @Test
    void shouldSortDescByTitle(){
        List<Element> expectedOrder = new LinkedList<>();
        expectedOrder.add(firstElement);
        expectedOrder.add(thirdElement);
        expectedOrder.add(secondElement);

        SortSettings sortSettings = new SortSettings(SortDirection.DESC, SortPriority.TITLE);
        faqRepo.sortList(sortSettings);

        Assertions.assertEquals(expectedOrder,faqRepo.getFaqList());
    }

    @Test
    void shouldSortDescById() {
        List<Element> expectedOrder = new LinkedList<>();
        expectedOrder.add(thirdElement);
        expectedOrder.add(secondElement);
        expectedOrder.add(firstElement);

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