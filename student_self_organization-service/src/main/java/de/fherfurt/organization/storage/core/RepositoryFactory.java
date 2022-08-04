package de.fherfurt.organization.storage.core;

import de.fherfurt.organization.forum.core.Answer;
import de.fherfurt.organization.forum.core.Message;
import de.fherfurt.organization.forum.core.Question;
import de.fherfurt.organization.storage.repository.AnswerRepository;
import de.fherfurt.organization.storage.repository.MessageRepository;
import de.fherfurt.organization.storage.repository.QuestionRepository;
import de.fherfurt.organization.storage.repository.RepositoryImpl;

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

        this.repository = new RepositoryImpl(this.getMessageDao(), this.getAnswerDao(), this.getQuestionDao() );

        // TODO: ADD TEST DATA
    }

    public MessageRepository getMessageRepository() {
        return this.repository;
    }

    public AnswerRepository getAnswerRepository() {
        return this.repository;
    }

    public QuestionRepository getQuestionRepository() {
        return this.repository;
    }

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
}
