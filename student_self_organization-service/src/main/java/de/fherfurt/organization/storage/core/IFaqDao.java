package de.fherfurt.organization.storage.core;

import de.fherfurt.organization.core.models.Element;

import java.util.List;

public interface IFaqDao extends IGenericDao<Element> {

    List<Element> findElementByTitle(String title);

    List<Element> findElementByAuthor(String author);
}
