package de.fherfurt.organization.storage.repository;

import de.fherfurt.organization.core.models.Element;

import java.util.List;

/**
 * Interface for faq repository
 *
 * @author Felix Zwicker
 */
public interface FaqRepositiory {

    boolean createElement(Element element);

    Element getElementById(int elementId);

    List<Element> getElementsByTitle(String title);

    List<Element> getElementsByAuthor(String author);

    boolean updateElementById(Element element);

    boolean deleteElementById(int elementId);

    List<Element> getAllElements();
}
