package de.fherfurt.organization.storage.core;

import de.fherfurt.organization.models.Element;
import de.fherfurt.organization.storage.core.IGenericDao;

import java.util.List;

public interface IFaqDao extends IGenericDao<Element> {

    List<Element> findElementByTitle(String title);

    List<Element> findElementByAuthor(String author);
}
