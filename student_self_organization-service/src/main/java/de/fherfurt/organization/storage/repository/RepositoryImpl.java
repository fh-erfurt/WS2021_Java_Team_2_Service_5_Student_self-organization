package de.fherfurt.organization.storage.repository;

import de.fherfurt.organization.models.Answer;
import de.fherfurt.organization.models.Element;
import de.fherfurt.organization.models.Message;
import de.fherfurt.organization.models.Question;
import de.fherfurt.organization.storage.core.IFaqDao;
import de.fherfurt.organization.storage.core.IGenericDao;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements  MessageRepository, AnswerRepository, QuestionRepository, IFaqRepositiory{

    private final IGenericDao<Message> messageDao;
    private final IGenericDao<Answer> answerDao;
    private final IGenericDao<Question> questionDao;
    private final IGenericDao<Element> elementDao;

    private final IFaqDao faqDao;

    public RepositoryImpl (IGenericDao<Message> messageDao, IGenericDao<Answer> answerDao, IGenericDao<Question> questionDao, IGenericDao<Element> elementDao, IFaqDao faqDao) {
        this.messageDao = messageDao;
        this.answerDao = answerDao;
        this.questionDao = questionDao;
        this.elementDao = elementDao;
        this.faqDao = faqDao;
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

    /*
        Faq Repository Implementation
     */

    @Override
    public boolean createElement(Element element) {
        return this.elementDao.create(element);
    }

    @Override
    public Element getElementById(int elementId) {
        return this.elementDao.findById(elementId);
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
