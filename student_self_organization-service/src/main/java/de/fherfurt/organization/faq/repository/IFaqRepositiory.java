package de.fherfurt.organization.faq.repository;

import de.fherfurt.organization.faq.model.Element;

import java.util.List;

public interface IFaqRepositiory {

    boolean createElement(Element element);

    Element getElementById(int elementId);

    List<Element> getElementsByTitle(String title);

    List<Element> getElementsByAuthor(String author);

    boolean updateElementById(Element element);

    boolean deleteElementById(int elementId);

    List<Element> getAllElements();
}
