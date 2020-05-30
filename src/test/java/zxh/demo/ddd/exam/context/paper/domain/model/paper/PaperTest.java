package zxh.demo.ddd.exam.context.paper.domain.model.paper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * PaperTest:
 * @author zhangxuhai
 * @date 2020/4/17
*/
public class PaperTest {
    private String fakeTeacherId = "fake-teacher-id";
    private List<BlankQuiz> quizzes = List.of(
            new BlankQuiz("q1", "a1", 5),
            new BlankQuiz("q2", "a2", 5),
            new BlankQuiz("q3", "a3", 5),
            new BlankQuiz("q4", "a4", 5),
            new BlankQuiz("q5", "a5", 5)
    );
    public static final Random RANDOM = new Random();

    @Test
    void should_create_paper() {
        Paper paper = Paper.create(new PaperId("id"), fakeTeacherId, quizzes);
        assertThat(paper, notNullValue());
    }

    @Test
    void should_fail_when_validate_blank_quizzes_given_less_than_5_quiz() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Paper.validateBlankQuizzes(List.of()));

        assertThat("Given quizzes less than 5.", is(exception.getMessage()));
    }

    @Test
    void should_fail_when_validate_blank_quizzes_given_more_than_20_quiz() {
        List<BlankQuiz> blankQuizzes = IntStream.range(0, 25)
                .mapToObj(i -> new BlankQuiz(
                        String.valueOf(RANDOM.nextInt()), String.valueOf(RANDOM.nextInt()), RANDOM.nextInt()))
                .collect(Collectors.toList());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Paper.validateBlankQuizzes(blankQuizzes));

        assertThat("Given quizzes more than 20.", is(exception.getMessage()));
    }

    @Test
    void should_update_blank_quizzes() {
        Paper paper = Paper.create(new PaperId("id"), fakeTeacherId, quizzes);
        ArrayList<BlankQuiz> newBlankQuizs = new ArrayList<>(quizzes);
        newBlankQuizs.add(new BlankQuiz("q5", "a5", 5));

        paper.updateBlankQuizzes(newBlankQuizs);

        assertThat(paper.getBlankQuizzes().size(), is(6));
    }
}
