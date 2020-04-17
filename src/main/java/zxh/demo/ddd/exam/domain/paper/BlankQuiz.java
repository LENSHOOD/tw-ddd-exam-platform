package zxh.demo.ddd.exam.domain.paper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import zxh.demo.ddd.exam.domain.share.ValueObject;
import java.util.Objects;

/**
 * BlankQuiz:
 * @author zhangxuhai
 * @date 2020/4/17
*/
@AllArgsConstructor
@Getter
public class BlankQuiz implements ValueObject {
    private String question;
    private String answer;
    private int score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlankQuiz blankQuiz = (BlankQuiz) o;
        return Objects.equals(question, blankQuiz.question) &&
                Objects.equals(answer, blankQuiz.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), question, answer, score);
    }
}
