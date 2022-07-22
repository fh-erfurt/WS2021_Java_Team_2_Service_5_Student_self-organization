package de.fherfurt.organization.storage.core;

import de.fherfurt.organization.forum.core.Question;
import de.fherfurt.organization.forum.core.Answer;

import java.util.List;

public interface QuestionDao extends IGenericDao<Question> {
    List<Question> getQuestionsByTopic(String topic );

    List<Question> getQuestionsByTitle( String title );

    List<Question> getQuestionsByAuthor( String author );

    List<Answer> getAnswersFromQuestion( int questionId );
}
