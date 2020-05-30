package zxh.demo.ddd.exam.context.quizbank.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank.BlankQuiz;
import zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank.QuizBankId;
import java.util.List;

/**
 * UpdateQuizBankCommand:
 * @author zhangxuhai
 * @date 2020/5/30
*/
@AllArgsConstructor
@Getter
public class UpdateQuizBankCommand {
    private QuizBankId id;
    private List<BlankQuiz> blankQuizzes;
}
