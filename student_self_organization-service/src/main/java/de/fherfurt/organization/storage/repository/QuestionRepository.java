package de.fherfurt.organization.storage.repository;

import de.fherfurt.organization.core.models.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getAllQuestions();

    Question getQuestion( int questionId );
    boolean createQuestion( Question question );
    boolean updateQuestion( Question question );
    boolean deleteQuestion( int questionId );
}
