package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

import static java.util.Objects.isNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import zxh.demo.ddd.exam.context.quizbank.domain.share.ValueObject;

/**
 * BlankQuiz:
 * @author zhangxuhai
 * @date 2020/4/17
*/
@AllArgsConstructor
@Getter
public class BlankQuiz implements ValueObject {
    private static final int CORRECT_SCORE = 5;
    private static final int WRONG_SCORE = 0;
    private String description;
    private String referencedAnswer;
    private int score;

    public void judge(Answer answer) {
        score = WRONG_SCORE;
        if (isNull(answer)) {
            return;
        }

        if (referencedAnswer.equals(answer.getAnswer())) {
            score = CORRECT_SCORE;
        }
    }
}
