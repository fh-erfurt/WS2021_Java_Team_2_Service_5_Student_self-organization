package de.fherfurt.organization.faq.repository;

import de.fherfurt.organization.faq.core.IFaqDao;
import de.fherfurt.organization.faq.core.JpaFaqDao;
import de.fherfurt.organization.faq.model.Element;
import de.fherfurt.organization.storage.core.IGenericDao;
import de.fherfurt.organization.storage.core.JpaGenericDao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FaqRepositioryFactory {

    private static final String PERSISTENCE_UNIT_NAME = "";

    private final EntityManagerFactory entityManagerFactory;
    private final FaqRepositioryImpl repo;

    private static FaqRepositioryFactory INSTANCE;

    public static FaqRepositioryFactory getInstance(){
        if(INSTANCE == null)
            INSTANCE = new FaqRepositioryFactory();

        return INSTANCE;
    }

    public FaqRepositioryFactory(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory((PERSISTENCE_UNIT_NAME));

        this.repo = new FaqRepositioryImpl(this.getFaqDao(), this.getElementDao());
    }

    public IFaqDao getFaqDao(){
        return new JpaFaqDao(this.entityManagerFactory.createEntityManager());
    }

    public IGenericDao<Element> getElementDao(){
        return new JpaGenericDao<>(Element.class, this.entityManagerFactory.createEntityManager());
    }

    public IFaqRepositiory getFaqRepository(){
        return this.repo;
    }
}
