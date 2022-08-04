package de.fherfurt.organization.storage.repository;

import de.fherfurt.organization.forum.core.Question;
import de.fherfurt.organization.forum.core.Answer;
import de.fherfurt.organization.forum.core.Topic;

import java.util.List;

public interface ForumRepository {

    boolean addNewQuestion( Question question );

    Question getQuestionById( int questionId );

    boolean removeQuestion( int questionId );

    List<Question> getAllQuestions();

    List<Question> getQuestionsByTopic( String topic );

    List<Question> getQuestionsByTitle( String title );

    List<Question> getQuestionsByAuthor( String author );

    List<Answer> getAnswersFromQuestion( int questionId );

    boolean addNewAnswerToQuestion( int questionId, Answer answer);

    List<Topic> getAllTopics();

    boolean addNewTopic( String newTopic );

    boolean removeTopic( int topicId );
}
