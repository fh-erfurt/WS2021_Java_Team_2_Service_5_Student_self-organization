package de.fherfurt.organization.faq.repository;

import de.fherfurt.organization.faq.core.Element;
import de.fherfurt.organization.faq.core.SortSettings;
import de.fherfurt.organization.faq.core.errors.EntryNotFoundException;

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
     * adds Element to List
     * creates elementId for Element
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
     * removes Element from List
     *
     * @param elementId ID of Element
     * @throws EntryNotFoundException when no object with searched ID exists
     * @see EntryNotFoundException
     */
    public void deleteElementById(int elementId) throws EntryNotFoundException {
        faqList.remove(getElementById(elementId));
    }

    /**
     * searches through the list by stream
     * and returns found Element
     *
     * @param elementId ID of searched Element
     * @return found Element
     * @throws EntryNotFoundException when no object with searched id exists
     * @see EntryNotFoundException
     */
    public Element getElementById(int elementId) throws EntryNotFoundException {
        Element searchedElement = faqList.stream()
                .filter(Elements -> elementId == Elements.getElementId())
                .findAny()
                .orElse(null);

        if (searchedElement == null) {
            throw new EntryNotFoundException("Element with ID: " + elementId + " couldnt be found");
        }
        return searchedElement;
    }

    /**
     * Iterator to go through the list
     * adds found objects to new created list
     *
     * @param author author of searched Elements
     * @return new created list containing Elements with same author
     * @throws EntryNotFoundException when no object with searched author exists
     * @see EntryNotFoundException
     */
    public List<Element> getElementsByAuthor(String author) throws EntryNotFoundException {
        List<Element> sameAuthor = new LinkedList<>();
        for (Element element : faqList) {
            if (element.getAuthor().equals(author)) {
                sameAuthor.add(element);
            }
        }
        if (sameAuthor.size() == 0) {
            throw new EntryNotFoundException("No Elements with Author: " + author + " found");
        }
        return sameAuthor;
    }

    /**
     * sorts the faqList
     *
     * @param sortSettings declared preferences for order
     * @see SortSettings
     */
    public void sortList(SortSettings sortSettings) {
        faqList.sort(new SortFaq(sortSettings));
    }

    public List<Element> getFaqList() {
        return faqList;
    }

    public void clearFaqList() {
        faqList.clear();
    }

    public void printFaqList() {
        System.out.println(faqList);
    }
}
