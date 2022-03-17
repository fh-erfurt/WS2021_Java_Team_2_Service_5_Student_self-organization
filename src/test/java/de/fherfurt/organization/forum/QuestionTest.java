package de.fherfurt.organization.forum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Class for Forum
 *
 * @author Jenny Wagner
 */
class QuestionTest {

    Question createTestQuestion () {
        Question question = new Question("Allgemeine Fragen", "Allgemeine Fragen", "Wann ist Semesterbeginn ??", "");

        question.addAnswer("Studienbeginn", "Studienbeginn ist 4.4.2022", "Herr Vorragend");

        return question;
    }

    @Test
    void shouldRemoveAnswer () {
        // given
        Question question = createTestQuestion();

        String title = "Studienbeginn";
        // when
        boolean result = question.removeAnswer(title);
        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void shouldNotRemoveAnswer () {
        // given
        Question question = createTestQuestion();

        String title = "Semesterende";
        // when
        boolean result = question.removeAnswer(title);
        // then
        Assertions.assertThat(result).isFalse();
    }

}