package de.fherfurt.organization.forum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Test Class for Forum
 *
 * @author Friedemann Taubert
 */
class ForumRepositoryTest {

    ForumRepository createTestForum() {
        ForumRepository forumRepository = new ForumRepository();

        forumRepository.addNewTopic("Allgemeine Fragen");
        forumRepository.addNewQuestion("Allgemeine Fragen", "Semesterbeginn ?", "Wann ist Semesterbeginn ??", "");
        forumRepository.addNewQuestion("Allgemeine Fragen", "Weg zum Campus", "Wie komme ich am besten zum Campus Altonaer Straße?", "");

        forumRepository.addNewTopic("Präsenz Maßnahmen");
        forumRepository.addNewQuestion("Präsenz Maßnahmen", "Aktuelle Regeln ?", "Was sind die aktullen Maßnahmen für Präsenz Unterricht ?", "");

        return forumRepository;
    }

    @Test
    void shouldRemoveQuestion() {
        // given
        ForumRepository forumRepository = createTestForum();

        String title = "Semesterbeginn ?";
        // when
        boolean result = forumRepository.removeQuestion(title);
        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void shouldNotRemoveQuestionDueTitleNotFound() {
        // given
        ForumRepository forumRepository = createTestForum();

        String title = "Corona Tests";
        // when
        boolean result = forumRepository.removeQuestion(title);
        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void shouldNotRemoveQuestionDueSize() {
        // given
        ForumRepository forumRepository = new ForumRepository();

        String title = "Corona Tests";
        // when
        boolean result = forumRepository.removeQuestion(title);
        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void shouldGetByTopic() {
        // given
        ForumRepository forumRepository = createTestForum();

        String topic = "Allgemeine Fragen";
        // when
        ArrayList<Question> result = forumRepository.getByTopic(topic);
        // then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void shouldNotGetByTopicDueSize() {
        // given
        ForumRepository forumRepository = new ForumRepository();

        String topic = "Allgemeine Fragen";
        // when
        ArrayList<Question> result = forumRepository.getByTopic(topic);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldNotGetByTopicDueTopicNotFound() {
        // given
        ForumRepository forumRepository = createTestForum();

        String topic = "Corona";
        // when
        ArrayList<Question> result = forumRepository.getByTopic(topic);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldBeTopic() {
        // given
        ForumRepository forumRepository = createTestForum();

        String topic = "Allgemeine Fragen";
        // when
        boolean result = forumRepository.isTopic(topic);
        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void shouldNotBeTopic() {
        // given
        ForumRepository forumRepository = createTestForum();

        String topic = "Corona";
        // when
        boolean result = forumRepository.isTopic(topic);
        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void shouldGetByQuestionTitle() {
        // given
        ForumRepository forumRepository = createTestForum();

        String title = "Aktuelle Regeln ?";
        // when
        ArrayList<Question> result = forumRepository.getByQuestionTitle(title);
        // then
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void shouldNotGetByQuestionTitleDueWrongTitle() {
        // given
        ForumRepository forumRepository = createTestForum();

        String title = "Impfpflicht";
        // when
        ArrayList<Question> result = forumRepository.getByQuestionTitle(title);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldNotGetByQuestionTitleDueNoQuestions() {
        // given
        ForumRepository forumRepository = new ForumRepository();

        String title = "Aktuelle Regeln ?";
        // when
        ArrayList<Question> result = forumRepository.getByQuestionTitle(title);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldGetByQuestionAuthor() {
        // given
        ForumRepository forumRepository = createTestForum();

        String author = "";
        // when
        ArrayList<Question> result = forumRepository.getByQuestionAuthor(author);
        // then
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void shouldNotGetByQuestionAuthorDueWrongAuthor() {
        // given
        ForumRepository forumRepository = createTestForum();

        String author = "Herr Vorragend";
        // when
        ArrayList<Question> result = forumRepository.getByQuestionAuthor(author);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldNotGetByQuestionAuthorDueNoQuestions() {
        // given
        ForumRepository forumRepository = new ForumRepository();

        String author = "";
        // when
        ArrayList<Question> result = forumRepository.getByQuestionAuthor(author);
        // then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldAddNewTopic() {
        // given
        ForumRepository forumRepository = createTestForum();

        String topic = "Mensa";
        // when
        boolean result = forumRepository.addNewTopic(topic);
        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void shouldNotAddNewTopic() {
        // given
        ForumRepository forumRepository = createTestForum();

        String topic = "Allgemeine Fragen";
        // when
        boolean result = forumRepository.addNewTopic(topic);
        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void shouldRemoveTopic() {
        // given
        ForumRepository forumRepository = createTestForum();

        String topic = "Allgemeine Fragen";
        // when
        boolean result = forumRepository.removeTopic(topic);
        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void shouldNotRemoveTopic() {
        // given
        ForumRepository forumRepository = createTestForum();

        String topic = "Mensa";
        // when
        boolean result = forumRepository.removeTopic(topic);
        // then
        Assertions.assertThat(result).isFalse();
    }
}
