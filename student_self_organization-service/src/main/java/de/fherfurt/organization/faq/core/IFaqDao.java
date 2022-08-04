package de.fherfurt.organization.faq.core;

import de.fherfurt.organization.faq.model.Element;
import de.fherfurt.organization.storage.core.IGenericDao;

import java.util.List;

public interface IFaqDao extends IGenericDao<Element> {

    Element findElementById(int id);

    List<Element> findElementByTitle(String title);

    List<Element> findElementByAuthor(String author);
}
