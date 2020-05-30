package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class QuizBankTest {
    @Test
    void should_create_QuizBank() {
        // given
        QuizBankId id = new QuizBankId("id");
        ArrayList<BlankQuiz> blankQuizzes = Lists.newArrayList(new BlankQuiz("quiz1", "correct", 5),
                new BlankQuiz("quiz2", "correct", 10),
                new BlankQuiz("quiz3", "correct", 15));

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
        ArrayList<BlankQuiz> blankQuizzes = Lists.newArrayList(new BlankQuiz("quiz1", "correct", 5),
                new BlankQuiz("quiz2", "correct", 10),
                new BlankQuiz("quiz3", "correct", 15));
        QuizBank quizBank = QuizBank.create(id, blankQuizzes);

        // when
        blankQuizzes.add(new BlankQuiz("quiz4", "correct", 1));
        quizBank.update(blankQuizzes);

        // then
        assertThat(quizBank.getBlankQuizzes().size(), is(4));
    }
}