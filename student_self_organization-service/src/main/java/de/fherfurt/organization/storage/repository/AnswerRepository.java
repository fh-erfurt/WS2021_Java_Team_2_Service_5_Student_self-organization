package de.fherfurt.organization.storage.repository;

import de.fherfurt.organization.forum.core.Answer;

import java.util.List;

public interface AnswerRepository {
    List<Answer> getAllAnswers();

    Answer getAnswer( int answerId );
    boolean createAnswer( Answer answer );
    boolean updateAnswer( Answer answer );
    boolean deleteAnswer( int answerId );
}
