package zxh.demo.ddd.exam.context.paper.domain.model.paper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class BlankQuizTest {
    @Test
    void should_return_correct_score_when_answer_right() {
        BlankQuiz quiz = new BlankQuiz("q1", "a1", 5);

        int score = quiz.judgeAnswer("a1");

        assertThat(score, is(5));
    }

    @Test
    void should_return_zero_score_when_answer_wrong() {
        BlankQuiz quiz = new BlankQuiz("q1", "a1", 5);

        int score = quiz.judgeAnswer("a0");

        assertThat(score, is(0));
    }
}