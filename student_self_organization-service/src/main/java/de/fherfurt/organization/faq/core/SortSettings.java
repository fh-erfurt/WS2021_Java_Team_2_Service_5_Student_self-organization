package de.fherfurt.organization.faq.core;

import de.fherfurt.organization.faq.core.enums.SortDirection;
import de.fherfurt.organization.faq.core.enums.SortPriority;

/**
 * Class to create needed sort settings
 *
 * @author Felix Zwicker
 */
public class SortSettings {

    private SortDirection sortDirection;
    private SortPriority sortPriority;

    /**
     * Constructor
     *
     * @param sortDirection enum for ASC or DESC order
     * @param sortPriority enum TITLE, DATE, ID for prioritized order
     */
    public SortSettings(SortDirection sortDirection, SortPriority sortPriority){
        this.sortDirection = sortDirection;
        this.sortPriority = sortPriority;
    }

    public void setSortDirection(SortDirection sortDirection){
        this.sortDirection = sortDirection;
    }

    public void setSortPriority(SortPriority sortPriority){
        this.sortPriority = sortPriority;
    }

    public SortDirection getSortDirection(){
        return sortDirection;
    }

    public SortPriority getSortPriority(){
        return sortPriority;
    }
}
