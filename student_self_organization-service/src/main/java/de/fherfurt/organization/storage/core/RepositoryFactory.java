package de.fherfurt.organization.storage.core;

import de.fherfurt.organization.forum.core.Answer;
import de.fherfurt.organization.forum.core.Message;
import de.fherfurt.organization.forum.core.Topic;
import de.fherfurt.organization.storage.repository.ForumRepository;
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

        this.repository = new RepositoryImpl(this.getMessageDao(), this.getAnswerDao(), this.getQuestionDao(), this.getTopicDao() );

        // TODO: ADD TEST DATA
    }

    public ForumRepository getForumRepository() {
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

    public QuestionDao getQuestionDao() {
        return new JpaQuestionDao( this.entityManagerFactory.createEntityManager() );
    }

    public IGenericDao<Topic> getTopicDao() {
        return new JpaGenericDao<>( Topic.class,
                this.entityManagerFactory.createEntityManager() );
    }
}
