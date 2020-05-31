package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class BlankQuizTest {
    @Test
    void should_judge_correct_answer() {
        // given
        BlankQuizId id = new BlankQuizId("id");
        String description = "test-blank-quiz";
        String referencedAnswer = "correct";
        BlankQuiz blankQuiz = new BlankQuiz(id, description, referencedAnswer, 5);

        // when
        blankQuiz.judge(new Answer("correct"));

        // then
        assertThat(blankQuiz.getScore(), is(5));
    }

    @Test
    void should_judge_wrong_answer() {
        // given
        String description = "test-blank-quiz";
        String referencedAnswer = "correct";
        BlankQuizId id = new BlankQuizId("id");
        BlankQuiz blankQuiz = new BlankQuiz(id, description, referencedAnswer, 5);

        // when
        blankQuiz.judge(new Answer("wrong"));

        // then
        assertThat(blankQuiz.getScore(), is(0));
    }
}