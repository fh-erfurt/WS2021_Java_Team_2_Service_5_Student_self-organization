package de.fherfurt.organization.storage.repository;

import de.fherfurt.organization.core.enums.Priority;
import de.fherfurt.organization.core.models.*;
import de.fherfurt.organization.storage.core.IFaqDao;
import de.fherfurt.organization.storage.core.IGenericDao;
import de.fherfurt.organization.storage.core.ITaskDao;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements  MessageRepository, AnswerRepository, QuestionRepository, IFaqRepositiory, TodoRepository{

    private final IGenericDao<Message> messageDao;
    private final IGenericDao<Answer> answerDao;
    private final IGenericDao<Question> questionDao;
    private final IGenericDao<Element> elementDao;
    private final IGenericDao<Task> taskDao;

    private final IFaqDao faqDao;

    private final ITaskDao todoDao;

    public RepositoryImpl (IGenericDao<Message> messageDao, IGenericDao<Answer> answerDao, IGenericDao<Question> questionDao,
                           IGenericDao<Element> elementDao, IFaqDao faqDao, IGenericDao<Task> taskDao, ITaskDao todoDao) {
        this.messageDao = messageDao;
        this.answerDao = answerDao;
        this.questionDao = questionDao;
        this.elementDao = elementDao;
        this.faqDao = faqDao;
        this.taskDao = taskDao;
        this.todoDao = todoDao;
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

    //todo_Implementation

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>( this.taskDao.findAll() );
    }

    @Override
    public Task getTask(int taskId) {
        return this.taskDao.findById( taskId );
    }

    @Override
    public boolean deleteTask(int taskId) {
       return this.taskDao.delete(taskId);
    }

    @Override
    public boolean createTask(Task task) {
        return this.taskDao.create(task);
    }

    @Override
    public boolean updateTask(Task task) {
        return this.taskDao.update(task) == task;
    }

    @Override
    public List<Task> getTaskByChecked(boolean isChecked) {
        return this.todoDao.findTaskByChecked(isChecked);
    }

    @Override
    public List<Task> getTaskByPriority(Priority priority) {
        return this.todoDao.findTaskByPriority(priority);
    }

    @Override
    public List<Task> getTaskByUnchecked(boolean isChecked) {
        return this.todoDao.findTaskByUnchecked(isChecked);
    }
}
