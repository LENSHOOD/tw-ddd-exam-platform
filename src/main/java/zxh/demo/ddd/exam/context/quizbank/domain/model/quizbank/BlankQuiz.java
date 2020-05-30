package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

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
    private String description;
    private String referencedAnswer;
    private int score;
}
