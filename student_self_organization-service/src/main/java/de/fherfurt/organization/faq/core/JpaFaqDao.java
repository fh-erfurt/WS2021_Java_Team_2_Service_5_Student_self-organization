package de.fherfurt.organization.faq.core;

import de.fherfurt.organization.faq.model.Element;
import de.fherfurt.organization.storage.core.JpaGenericDao;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class JpaFaqDao extends JpaGenericDao<Element> implements IFaqDao {

    public JpaFaqDao(EntityManager entityManager){
        super(Element.class, entityManager);
    }

    @Override
    public Element findElementById(int id){
        return this.findById(id);
    }

    @Override
    public List<Element> findElementByTitle(String title) {
        return this.findAll()
                .stream()
                .filter( Element -> title.equals(Element.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Element> findElementByAuthor(String author) {
        return this.findAll()
                .stream()
                .filter( Element -> author.equals(Element.getAuthor()))
                .collect(Collectors.toList());
    }
}
