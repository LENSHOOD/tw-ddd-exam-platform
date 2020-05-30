package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import zxh.demo.ddd.exam.context.quizbank.domain.share.ValueObject;
import java.util.Objects;

/**
 * QuizBankId:
 * @author zhangxuhai
 * @date 2020/5/30
*/
@AllArgsConstructor
@Getter
public class QuizBankId implements ValueObject {
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizBankId that = (QuizBankId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
