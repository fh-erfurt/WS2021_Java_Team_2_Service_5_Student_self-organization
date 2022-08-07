package de.fherfurt.organization.storage.core;

import de.fherfurt.organization.core.models.Element;

import java.util.List;

/**
 * abstract layer between IGenericDao and the repository-layer with specific methods of the faq.
 *
 * @author Felix Zwicker
 */
public interface IFaqDao extends IGenericDao<Element> {

    /**
     * searches for all elements with the same title
     * @param title searched string
     * @return list of found elements
     */
    List<Element> findElementByTitle(String title);

    /**
     * searches for all elements with the same author
     * @param author searched author
     * @return list of found elements
     */
    List<Element> findElementByAuthor(String author);
}
