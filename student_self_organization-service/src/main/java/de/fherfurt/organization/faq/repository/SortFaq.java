package de.fherfurt.organization.faq.repository;

import de.fherfurt.organization.faq.core.enums.SortDirection;
import de.fherfurt.organization.faq.core.enums.SortPriority;
import de.fherfurt.organization.faq.core.SortSettings;
import de.fherfurt.organization.faq.core.Elements;

import java.util.Comparator;

/**
 * Class to sort lists
 * implements Comparator to compare objects
 *
 * @author Felix Zwicker
 */
public class SortFaq implements Comparator<Elements> {

    private final SortSettings sortSettings;

    /**
     * Constructor
     *
     * @param sortSettings prior declared sort settings
     * @see SortSettings
     */
    public SortFaq(SortSettings sortSettings){
        this.sortSettings = sortSettings;
    }

    /**
     * compares two objects and sorts them
     *
     * @param firstElement first object to compare
     * @param secondElement second object to compare
     * @return solution solution of comparisons * direction for asc or desc order
     */
    @Override
    public int compare(Elements firstElement, Elements secondElement){
        int solution = 0;
        int direction = 1;

        if(sortSettings.getSortDirection() == SortDirection.DESC)
            direction = -1;

        if(firstElement == null && secondElement == null)
            solution = 0;
        else if(sortSettings.getSortPriority() == SortPriority.TITLE)
            solution = firstElement.getTitle().compareTo(secondElement.getTitle());
        else if(sortSettings.getSortPriority() == SortPriority.DATE)
            solution = firstElement.getDate().compareTo(secondElement.getDate());
        else if(sortSettings.getSortPriority() == SortPriority.ID)
            solution = firstElement.getElementId() - (secondElement.getElementId());

        return solution * direction;
    }
}

