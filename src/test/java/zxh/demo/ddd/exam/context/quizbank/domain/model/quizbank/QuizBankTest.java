package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Optional;

class QuizBankTest {
    @Test
    void should_create_QuizBank() {
        // given
        QuizBankId id = new QuizBankId("id");
        ArrayList<BlankQuiz> blankQuizzes = Lists.newArrayList(
                new BlankQuiz(new BlankQuizId("id1"), "quiz1", "correct", 5),
                new BlankQuiz(new BlankQuizId("id2"), "quiz2", "correct", 10),
                new BlankQuiz(new BlankQuizId("id3"), "quiz3", "correct", 15));

        // when
        QuizBank quizBank = QuizBank.create(id, blankQuizzes);

        // then
        assertThat(quizBank.getId(), is(id));
        assertThat(quizBank.getBlankQuizzes(), is(blankQuizzes));
    }

    @Test
    void should_update_QuizBank() {
        // given
        QuizBankId id = new QuizBankId("id");
        ArrayList<BlankQuiz> blankQuizzes = Lists.newArrayList(
                new BlankQuiz(new BlankQuizId("id1"), "quiz1", "correct", 5),
                new BlankQuiz(new BlankQuizId("id2"), "quiz2", "correct", 10),
                new BlankQuiz(new BlankQuizId("id3"), "quiz3", "correct", 15));
        QuizBank quizBank = QuizBank.create(id, blankQuizzes);

        // when
        blankQuizzes.add(new BlankQuiz(new BlankQuizId("id4"), "quiz4", "correct", 1));
        quizBank.update(blankQuizzes);

        // then
        assertThat(quizBank.getBlankQuizzes().size(), is(4));
    }

    @Test
    void should_save_new_blank_quiz() {
        // given
        QuizBankId id = new QuizBankId("id");
        ArrayList<BlankQuiz> blankQuizzes = Lists.newArrayList(
                new BlankQuiz(new BlankQuizId("id1"), "quiz1", "correct", 5),
                new BlankQuiz(new BlankQuizId("id2"), "quiz2", "correct", 10),
                new BlankQuiz(new BlankQuizId("id3"), "quiz3", "correct", 15));
        QuizBank quizBank = QuizBank.create(id, blankQuizzes);

        // when
        BlankQuiz newBlankQuiz = new BlankQuiz(new BlankQuizId("id4"), "quiz4", "correct", 1);
        quizBank.saveBlankQuiz(newBlankQuiz);

        // then
        assertThat(quizBank.getBlankQuizzes().size(), is(4));
    }

    @Test
    void should_get_blank_quiz() {
        // given
        QuizBankId id = new QuizBankId("id");
        ArrayList<BlankQuiz> blankQuizzes = Lists.newArrayList(
                new BlankQuiz(new BlankQuizId("id1"), "quiz1", "correct", 5),
                new BlankQuiz(new BlankQuizId("id2"), "quiz2", "correct", 10),
                new BlankQuiz(new BlankQuizId("id3"), "quiz3", "correct", 15));
        QuizBank quizBank = QuizBank.create(id, blankQuizzes);

        // when
        Optional<BlankQuiz> blankQuiz1 = quizBank.findBlankQuiz(new BlankQuizId("id1"));

        // then
        assertTrue(blankQuiz1.isPresent());
        assertThat(blankQuiz1.get().getDescription(), is("quiz1"));
    }

    @Test
    void should_update_blank_quiz() {
        // given
        QuizBankId id = new QuizBankId("id");
        ArrayList<BlankQuiz> blankQuizzes = Lists.newArrayList(
                new BlankQuiz(new BlankQuizId("id1"), "quiz1", "correct", 5),
                new BlankQuiz(new BlankQuizId("id2"), "quiz2", "correct", 10),
                new BlankQuiz(new BlankQuizId("id3"), "quiz3", "correct", 15));
        QuizBank quizBank = QuizBank.create(id, blankQuizzes);

        // when
        BlankQuiz updatedBlankQuiz = new BlankQuiz(new BlankQuizId("id1"), "quiz4", "correct", 1);
        quizBank.saveBlankQuiz(updatedBlankQuiz);

        // then
        assertThat(quizBank.getBlankQuizzes().size(), is(3));
        assertThat(quizBank.findBlankQuiz(new BlankQuizId("id1")).get().getDescription(), is("quiz4"));
    }

    @Test
    void should_remove_blank_quiz() {
        // given
        QuizBankId id = new QuizBankId("id");
        ArrayList<BlankQuiz> blankQuizzes = Lists.newArrayList(
                new BlankQuiz(new BlankQuizId("id1"), "quiz1", "correct", 5),
                new BlankQuiz(new BlankQuizId("id2"), "quiz2", "correct", 10),
                new BlankQuiz(new BlankQuizId("id3"), "quiz3", "correct", 15));
        QuizBank quizBank = QuizBank.create(id, blankQuizzes);

        // when
        quizBank.removeBlankQuiz(new BlankQuizId("id1"));

        // then
        assertThat(quizBank.getBlankQuizzes().size(), is(2));
    }
}