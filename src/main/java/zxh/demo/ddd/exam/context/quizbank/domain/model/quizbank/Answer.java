package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import zxh.demo.ddd.exam.context.quizbank.domain.share.ValueObject;

/**
 * Answer:
 * @author zhangxuhai
 * @date 2020/5/30
*/
@AllArgsConstructor
@Getter
public class Answer implements ValueObject {
    String answer;
}
