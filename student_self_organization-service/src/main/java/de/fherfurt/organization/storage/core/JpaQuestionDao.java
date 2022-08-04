package de.fherfurt.organization.storage.core;

import de.fherfurt.organization.forum.core.Answer;
import de.fherfurt.organization.forum.core.Question;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class JpaQuestionDao extends JpaGenericDao<Question> implements QuestionDao {

    public JpaQuestionDao(EntityManager em ) {
        super(Question.class, em);
    }

    @Override
    public List<Question> getQuestionsByTopic(String topic) {
        return this.findAll()
                .stream()
                .filter( q -> q.getTopic().equalsIgnoreCase( topic ))
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> getQuestionsByTitle(String title) {
        return this.findAll()
                .stream()
                .filter( q -> q.getTitle().equalsIgnoreCase( title ))
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> getQuestionsByAuthor(String author) {
        return this.findAll()
                .stream()
                .filter( q -> q.getAuthor().equalsIgnoreCase( author ) )
                .collect(Collectors.toList());
    }

    @Override
    public List<Answer> getAnswersFromQuestion(int questionId ) {
        return this.findById( questionId ).getAnswers();
    }
}
