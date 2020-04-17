package zxh.demo.ddd.exam.domain.paper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * PaperTest:
 * @author zhangxuhai
 * @date 2020/4/17
*/
public class PaperTest {

    private String fakeTeacherId = "fake-teacher-id";
    private List quizzes = List.of(
            new BlankQuiz(),
            new BlankQuiz(),
            new BlankQuiz(),
            new BlankQuiz(),
            new BlankQuiz());

    @Test
    void should_create_paper() {
        Paper paper = Paper.create(new PaperId(), fakeTeacherId, quizzes);
        assertThat(paper, notNullValue());
    }

    @Test
    void should_fail_when_create_paper_given_less_than_5_quiz() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Paper.create(new PaperId(), fakeTeacherId, List.of()));

        assertThat("Given quizzes less than 5.", is(exception.getMessage()));
    }

    @Test
    void should_fail_when_create_paper_given_more_than_20_quiz() {
        List<BlankQuiz> blankQuizzes = IntStream.range(0, 25)
                .mapToObj(i -> new BlankQuiz())
                .collect(Collectors.toList());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Paper.create(new PaperId(), fakeTeacherId, blankQuizzes));

        assertThat("Given quizzes more than 20.", is(exception.getMessage()));
    }
}
