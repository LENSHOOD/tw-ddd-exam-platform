package zxh.demo.ddd.exam.domain.paper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * PaperTest:
 * @author zhangxuhai
 * @date 2020/4/17
*/
public class PaperTest {
    @Test
    void should_create_paper() {
        Paper paper = Paper.create(new PaperId(), "fake-teacher-id", List.of(new BlankQuiz()));
        assertThat(paper, notNullValue());
    }
}
