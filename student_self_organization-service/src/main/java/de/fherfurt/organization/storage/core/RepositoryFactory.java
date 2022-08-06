package de.fherfurt.organization.storage.core;

import de.fherfurt.organization.core.models.*;
import de.fherfurt.organization.storage.repository.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RepositoryFactory {
    private static final String PERSISTENCE_UNIT_NAME = "";

    private final EntityManagerFactory entityManagerFactory;
    private final RepositoryImpl repository;

    private static RepositoryFactory INSTANCE;

    public static RepositoryFactory getInstance() {
        if( INSTANCE == null ) {
            INSTANCE = new RepositoryFactory();
        }
        return INSTANCE;
    }

    private RepositoryFactory() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );

        this.repository = new RepositoryImpl(this.getMessageDao(), this.getAnswerDao(), this.getQuestionDao(), this.getElementDao(), this.getFaqDao(),
                this.getTaskDao(), this.getTodoDao());

        // TODO: ADD TEST DATA
    }

    /*
        Repo Getter
     */

    public MessageRepository getMessageRepository() {
        return this.repository;
    }

    public AnswerRepository getAnswerRepository() {
        return this.repository;
    }

    public QuestionRepository getQuestionRepository() {
        return this.repository;
    }

    public IFaqRepositiory getFaqRepository(){
        return this.repository;
    }

    public TodoRepository getTodoRepository() {
        return this.repository;
    }

    /*
        Dao Getter
     */

    public IGenericDao<Message> getMessageDao() {
        return new JpaGenericDao<>( Message.class,
                this.entityManagerFactory.createEntityManager() );
    }

    public IGenericDao<Answer> getAnswerDao() {
        return new JpaGenericDao<>( Answer.class,
                this.entityManagerFactory.createEntityManager() );
    }

    public IGenericDao<Question> getQuestionDao() {
        return new JpaGenericDao<>( Question.class,
                this.entityManagerFactory.createEntityManager() );
    }

    public IFaqDao getFaqDao(){
        return new JpaFaqDao(this.entityManagerFactory.createEntityManager());
    }

    public IGenericDao<Element> getElementDao() {
        return new JpaGenericDao<>(Element.class,
                this.entityManagerFactory.createEntityManager());
    }

    public IGenericDao<Task> getTaskDao() {
        return new JpaGenericDao<>(Task.class,
                this.entityManagerFactory.createEntityManager());
    }

    public ITaskDao getTodoDao() {
        return new JpaTaskDao(this.entityManagerFactory.createEntityManager());
    }
}
