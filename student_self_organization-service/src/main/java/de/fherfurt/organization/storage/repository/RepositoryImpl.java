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
        Answer Repository Implementation
    */

    @Override
    public List<Answer> getAllAnswers() {
        return new ArrayList<>( this.answerDao.findAll() );
    }

    @Override
    public Answer getAnswer(int answerId) {
        return this.answerDao.findById( answerId );
    }

    @Override
    public boolean createAnswer(Answer answer) {
        return this.answerDao.create( answer );
    }

    @Override
    public boolean updateAnswer(Answer answer) {
        return this.answerDao.update( answer ) == answer;
    }

    @Override
    public boolean deleteAnswer(int answerId) {
        return this.answerDao.delete( answerId );
    }

    /*
        Message Repository Implementation
     */

    @Override
    public List<Message> getAllMessages() {
        return new ArrayList<>( this.messageDao.findAll() );
    }

    @Override
    public Message getMessage(int messageId) {
        return this.messageDao.findById( messageId );
    }

    @Override
    public boolean createMessage(Message message) {
        return this.messageDao.create( message );
    }

    @Override
    public boolean updateMessage(Message message) {
        return this.messageDao.update( message ) == message;
    }

    @Override
    public boolean deleteMessage(int messageId) {
        return this.messageDao.delete( messageId );
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
