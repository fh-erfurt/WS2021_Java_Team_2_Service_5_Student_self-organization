package de.fherfurt.organization.faq.repository;

import de.fherfurt.organization.faq.core.enums.SortDirection;
import de.fherfurt.organization.faq.core.enums.SortPriority;
import de.fherfurt.organization.faq.core.SortSettings;
import de.fherfurt.organization.faq.core.Element;

import java.util.Comparator;

/**
 * Class to sort lists
 * implements Comparator to compare objects
 *
 * @author Felix Zwicker
 */
public class SortFaq implements Comparator<Element> {

    private final SortSettings sortSettings;

    /**
     * Constructor
     *
     * @param sortSettings - prior declared sort settings
     * @see SortSettings
     */
    public SortFaq(SortSettings sortSettings){
        this.sortSettings = sortSettings;
    }

    /**
     * compares two objects and sorts them
     *
     * @param firstElement - first object to compare
     * @param secondElement - second object to compare
     * @return int value - solution of comparison * direction for asc or desc order
     */
    @Override
    public int compare(Element firstElement, Element secondElement){
        int solution = 0;
        int direction = 1;

        assert firstElement != null;
        if(sortSettings.getSortDirection() == SortDirection.DESC){
            direction = -1;
        }

        if(sortSettings.getSortPriority() == SortPriority.TITLE){
            solution = firstElement.getTitle().compareTo(secondElement.getTitle());
        }
        else if(sortSettings.getSortPriority() == SortPriority.DATE){
            solution = firstElement.getDate().compareTo(secondElement.getDate());
        }
        else if(sortSettings.getSortPriority() == SortPriority.ID){
            solution = firstElement.getElementId() - (secondElement.getElementId());
        }

        //when direction was set to -1 the solution value is reversed
        //that brings the same result as reversing the sortOrder
        return solution * direction;
    }
}