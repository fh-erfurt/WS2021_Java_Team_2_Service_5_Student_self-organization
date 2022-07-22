package de.fherfurt.organization.storage.repository;

import de.fherfurt.organization.forum.core.*;
import de.fherfurt.organization.storage.core.IGenericDao;
import de.fherfurt.organization.storage.core.QuestionDao;

import java.util.List;

public class RepositoryImpl implements ForumRepository {

    private final IGenericDao<Message> messageDao;
    private final IGenericDao<Answer> answerDao;
    private final QuestionDao questionDao;
    private final IGenericDao<Topic> topicDao;

    public RepositoryImpl (IGenericDao<Message> messageDao, IGenericDao<Answer> answerDao, QuestionDao questionDao, IGenericDao<Topic> topicDao) {
        this.messageDao = messageDao;
        this.answerDao = answerDao;
        this.questionDao = questionDao;
        this.topicDao = topicDao;
    }

    /*
        Forum Repository Implementation
    */

    @Override
    public boolean addNewQuestion(Question question) {
        return this.questionDao.create( question );
    }

    @Override
    public Question getQuestionById( int questionId ) {
        return this.questionDao.findById( questionId );
    }

    @Override
    public boolean removeQuestion(int questionId) {
        return this.questionDao.delete( questionId );
    }

    @Override
    public List<Question> getAllQuestions() {
        return (List<Question>) this.questionDao.findAll();
    }

    @Override
    public List<Question> getQuestionsByTopic(String topic) {
        return this.questionDao.getQuestionsByTopic( topic );
    }

    @Override
    public List<Question> getQuestionsByTitle(String title) {
        return this.questionDao.getQuestionsByTitle( title );
    }

    @Override
    public List<Question> getQuestionsByAuthor(String author) {
        return this.questionDao.getQuestionsByAuthor( author );
    }

    @Override
    public boolean addNewAnswerToQuestion(int questionId, Answer answer) {
        this.questionDao.findById( questionId ).addAnswer( answer );
        return true;
    }

    @Override
    public List<Answer> getAnswersFromQuestion( int questionId ) {
        return this.questionDao.getAnswersFromQuestion( questionId );
    }

    @Override
    public List<Topic> getAllTopics() {
        return (List<Topic>) topicDao.findAll();
    }

    @Override
    public boolean addNewTopic(String newTopic) {
        return topicDao.create( new Topic( newTopic ));
    }

    @Override
    public boolean removeTopic(int topicId) {
        return topicDao.delete(topicId);
    }


}
