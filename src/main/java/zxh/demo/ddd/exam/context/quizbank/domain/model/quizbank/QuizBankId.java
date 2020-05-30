package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import zxh.demo.ddd.exam.context.quizbank.domain.share.ValueObject;

/**
 * QuizBankId:
 * @author zhangxuhai
 * @date 2020/5/30
*/
@AllArgsConstructor
@Getter
public class QuizBankId implements ValueObject {
    private String id;
}
