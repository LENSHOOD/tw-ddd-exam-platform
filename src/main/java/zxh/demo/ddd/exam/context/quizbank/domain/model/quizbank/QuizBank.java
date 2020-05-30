package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

/**
 * QuizBank:
 * @author zhangxuhai
 * @date 2020/5/30
*/
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QuizBank {
    private QuizBankId id;
    private List<BlankQuiz> blankQuizzes;

    public static QuizBank create(QuizBankId id, List<BlankQuiz> blankQuizzes) {
        return new QuizBank(id, blankQuizzes);
    }

    public void update(List<BlankQuiz> blankQuizzes) {
        this.blankQuizzes = blankQuizzes;
    }
}
