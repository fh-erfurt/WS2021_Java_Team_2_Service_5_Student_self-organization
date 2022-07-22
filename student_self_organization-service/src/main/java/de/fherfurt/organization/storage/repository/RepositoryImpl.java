package de.fherfurt.organization.storage.repository;

import de.fherfurt.organization.forum.core.Answer;
import de.fherfurt.organization.forum.core.Message;
import de.fherfurt.organization.forum.core.Question;
import de.fherfurt.organization.storage.core.IGenericDao;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements  MessageRepository, AnswerRepository, QuestionRepository{

    private final IGenericDao<Message> messageDao;
    private final IGenericDao<Answer> answerDao;
    private final IGenericDao<Question> questionDao;

    public RepositoryImpl (IGenericDao<Message> messageDao, IGenericDao<Answer> answerDao, IGenericDao<Question> questionDao) {
        this.messageDao = messageDao;
        this.answerDao = answerDao;
        this.questionDao = questionDao;
    }

    /*
        Forum Repository Implementation
    */

    @Override
    public boolean addNewQuestion(Question question) {
        return this.questionDao.create( question );
    }

    @Override
    public boolean removeQuestion(int questionId) {
        return this.questionDao.delete( questionId );
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
    public boolean addNewTopic(String newTopic) {
        return topicDao.create( new Topic( newTopic ));
    }

    @Override
    public boolean removeTopic(int topicId) {
        return topicDao.delete(topicId);
    }

    /*
        Question Repository Implementation
     */

    @Override
    public List<Question> getAllQuestions() {
        return new ArrayList<>( this.questionDao.findAll() );
    }

    @Override
    public Question getQuestion(int questionId) {
        return this.questionDao.findById( questionId );
    }

    @Override
    public boolean createQuestion(Question question) {
        return this.questionDao.create( question );
    }

    @Override
    public boolean updateQuestion(Question question) {
        return this.questionDao.update( question ) == question;
    }

    @Override
    public boolean deleteQuestion(int questionId) {
        return this.questionDao.delete( questionId );
    }
}
