package de.fherfurt.organization.faq.repository;

import de.fherfurt.organization.faq.core.IFaqDao;
import de.fherfurt.organization.faq.model.Element;
import de.fherfurt.organization.storage.core.IGenericDao;

import java.util.ArrayList;
import java.util.List;

public class FaqRepositioryImpl implements IFaqRepositiory{

    private final IFaqDao faqDao;
    private final IGenericDao<Element> elementDao;

    public FaqRepositioryImpl(IFaqDao faqDao, IGenericDao<Element> elementDao){
        this.faqDao = faqDao;
        this.elementDao = elementDao;
    }

    @Override
    public boolean createElement(Element element) {
        return this.elementDao.create(element);
    }

    @Override
    public Element getElementById(int elementId) {
        return this.faqDao.findElementById(elementId);
    }

    @Override
    public List<Element> getElementsByTitle(String title) {
        return this.faqDao.findElementByTitle(title);
    }

    @Override
    public List<Element> getElementsByAuthor(String author) {
        return this.faqDao.findElementByAuthor(author);
    }

    @Override
    public boolean updateElementById(Element element) {
        this.elementDao.update(element);
        return getElementById(element.getId()).equals(element);
    }

    @Override
    public boolean deleteElementById(int elementId) {
        return this.elementDao.delete(elementId);
    }

    @Override
    public List<Element> getAllElements() {
        return new ArrayList<>(this.elementDao.findAll());
    }
}
