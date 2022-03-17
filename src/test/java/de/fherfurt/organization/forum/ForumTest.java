package de.fherfurt.organization.forum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Test Class for Forum
 *
 * @author Friedemann Taubert
 */
class ForumTest {

    Forum createTestForum () {
        Forum forum = new Forum();

        forum.addNewTopic("Allgemeine Fragen");
        forum.addNewQuestion("Allgemeine Fragen", "Semesterbeginn ?", "Wann ist Semesterbeginn ??", "");
        forum.addNewQuestion("Allgemeine Fragen", "Weg zum Campus", "Wie komme ich am besten zum Campus Altonaer Straße?", "");

        forum.addNewTopic("Präsenz Maßnahmen");
        forum.addNewQuestion("Präsenz Maßnahmen", "Aktuelle Regeln ?", "Was sind die aktullen Maßnahmen für Präsenz Unterricht ?", "");

        return forum;
    }

    @Test
    void shouldRemoveQuestion () {
        // given
            // Was brauch ich für den Test
        Forum forum = createTestForum();

        String title = "Semesterbeginn ?";
        // when
            // zu testende Methode wird ausgeführt (Resultat gegebenenfalls gespeichert)
        boolean result = forum.removeQuestion(title);
        // then
            // Mit Assertions.assertThat wird Test ausgeführt
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void shouldNotRemoveQuestionDueTitleNotFound () {
        // given
        Forum forum = createTestForum();

        String title = "Corona Tests";
        // when
        boolean result = forum.removeQuestion(title);
        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void shouldNotRemoveQuestionDueSize () {
        // given
        Forum forum = new Forum();

        String title = "Corona Tests";
        // when
        boolean result = forum.removeQuestion(title);
        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void shouldGetByTopic () {
        // given
        Forum forum = createTestForum();

        String topic = "Allgemeine Fragen";
        // when
        ArrayList<Question> result = forum.getByTopic(topic);
        // then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void shouldNotGetByTopicDueSize () {
        // given
        Forum forum = new Forum();

        String topic = "Allgemeine Fragen";
        // when
        ArrayList<Question> result = forum.getByTopic(topic);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldNotGetByTopicDueTopicNotFound () {
        // given
        Forum forum = createTestForum();

        String topic = "Corona";
        // when
        ArrayList<Question> result = forum.getByTopic(topic);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldBeTopic () {
        // given
        Forum forum = createTestForum();

        String topic = "Allgemeine Fragen";
        // when
        boolean result = forum.isTopic(topic);
        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void shouldNotBeTopic () {
        // given
        Forum forum = createTestForum();

        String topic = "Corona";
        // when
        boolean result = forum.isTopic(topic);
        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void shouldGetByQuestionTitle () {
        // given
        Forum forum = createTestForum();

        String title = "Aktuelle Regeln ?";
        // when
        ArrayList<Question> result = forum.getByQuestionTitle(title);
        // then
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void shouldNotGetByQuestionTitleDueWrongTitle () {
        // given
        Forum forum = createTestForum();

        String title = "Impfpflicht";
        // when
        ArrayList<Question> result = forum.getByQuestionTitle(title);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldNotGetByQuestionTitleDueNoQuestions () {
        // given
        Forum forum = new Forum();

        String title = "Aktuelle Regeln ?";
        // when
        ArrayList<Question> result = forum.getByQuestionTitle(title);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldGetByQuestionAuthor () {
        // given
        Forum forum = createTestForum();

        String author = "";
        // when
        ArrayList<Question> result = forum.getByQuestionAuthor(author);
        // then
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void shouldNotGetByQuestionAuthorDueWrongAuthor () {
        // given
        Forum forum = createTestForum();

        String author = "Herr Vorragend";
        // when
        ArrayList<Question> result = forum.getByQuestionAuthor(author);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldNotGetByQuestionAuthorDueNoQuestions () {
        // given
        Forum forum = new Forum();

        String author = "";
        // when
        ArrayList<Question> result = forum.getByQuestionAuthor(author);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldAddNewTopic () {
        // given
        Forum forum = createTestForum();

        String topic = "Mensa";
        // when
        boolean result = forum.addNewTopic(topic);
        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void shouldNotAddNewTopic () {
        // given
        Forum forum = createTestForum();

        String topic = "Allgemeine Fragen";
        // when
        boolean result = forum.addNewTopic(topic);
        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void shouldRemoveTopic () {
        // given
        Forum forum = createTestForum();

        String topic = "Allgemeine Fragen";
        // when
        boolean result = forum.removeTopic(topic);
        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void shouldNotRemoveTopic () {
        // given
        Forum forum = createTestForum();

        String topic = "Mensa";
        // when
        boolean result = forum.removeTopic(topic);
        // then
        Assertions.assertThat(result).isFalse();
    }
}
