package de.fherfurt.organization.faq.repository;

import de.fherfurt.organization.faq.core.Element;
import de.fherfurt.organization.faq.core.SortSettings;
import de.fherfurt.organization.faq.core.errors.EntryNotFoundException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representing Repository for all Elements
 *
 * @author Felix Zwicker
 */
public class FaqRepository {
    private final List<Element> faqList;

    /**
     * Constructor creating a new LinkedList to save created Elements
     */
    FaqRepository() {
        faqList = new LinkedList<>();
    }

    /**
     * adds Elements to List
     * creates Id for Element
     *
     * @param element declared Element
     * @see Element
     */
    public void addElement(Element element) {
        Element lastElementInList;
        int lastElementId;

        //get id from last Element in List and adds 1 to new Element
        if (faqList.size() != 0) {
            lastElementInList = faqList.get(faqList.size() - 1);
            lastElementId = lastElementInList.getElementId();
            element.setElementId(lastElementId + 1);
        }
        //when no object in list, id is set to 1
        else {
            element.setElementId(1);
        }
        faqList.add(element);
    }

    /**
     * deletes Element
     *
     * @param elementId removes element with elementId
     * @throws EntryNotFoundException when no object with searched id exists
     */
    public void deleteElementById(int elementId) throws EntryNotFoundException {
        faqList.remove(getElementById(elementId));
    }

    /**
     * searches through the list by stream
     *
     * @param elementId searched object id
     * @return found element with needed id
     * @throws EntryNotFoundException when no object with searched id exists
     */
    public Element getElementById(int elementId) throws EntryNotFoundException {
        Element searchedElement = faqList.stream()
                .filter(Elements -> elementId == Elements.getElementId()).findAny().orElse(null);

        if (searchedElement == null) {
            throw new EntryNotFoundException("Element with ID: " + elementId + " couldnt be found");
        }
        return searchedElement;
    }

    /**
     * Iterator to go through the list
     * adds found objects to new created list
     *
     * @param author searched object author
     * @return created list size - needed for tests
     * @throws EntryNotFoundException when no object with searched author exists
     */
    public int getElementsByAuthorUsingIterator(String author) throws EntryNotFoundException {
        List<Element> sameAuthor = new LinkedList<>();
        for (Element element : faqList) {
            if (element.getAuthor().equals(author)) {
                sameAuthor.add(element);
            }
        }
        if (sameAuthor.size() == 0) {
            throw new EntryNotFoundException("No Elements with Author: " + author + " found");
        }
        return sameAuthor.size();
    }

    /**
     * sorts the faqList
     *
     * @param sortSettings declared preferences for order
     * @see SortSettings
     */
    public void sortList(SortSettings sortSettings) {
        Collections.sort(faqList, new SortFaq(sortSettings));
    }

    public void clearFaqList() {
        faqList.clear();
    }

    public List<Element> getFaqList() {
        return faqList;
    }

    public void printFaqList() {
        System.out.println(faqList);
    }
}
