package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import zxh.demo.ddd.exam.context.quizbank.domain.share.Entity;
import java.util.List;
import java.util.Optional;

/**
 * QuizBank:
 * @author zhangxuhai
 * @date 2020/5/30
*/
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QuizBank implements Entity {
    private QuizBankId id;
    private List<BlankQuiz> blankQuizzes;

    public static QuizBank create(QuizBankId id, List<BlankQuiz> blankQuizzes) {
        return new QuizBank(id, blankQuizzes);
    }

    public void update(List<BlankQuiz> blankQuizzes) {
        this.blankQuizzes = blankQuizzes;
    }

    public void saveBlankQuiz(BlankQuiz blankQuiz) {
        removeBlankQuiz(blankQuiz.getId());
        blankQuizzes.add(blankQuiz);
    }

    public Optional<BlankQuiz> findBlankQuiz(BlankQuizId blankQuizId) {
        return blankQuizzes.stream().filter(innerQuiz -> innerQuiz.getId().equals(blankQuizId)).findAny();
    }

    public void removeBlankQuiz(BlankQuizId blankQuizId) {
        blankQuizzes.removeIf(innerQuiz -> innerQuiz.getId().equals(blankQuizId));
    }

    public List<BlankQuiz> getBlankQuizzes() {
        return ImmutableList.copyOf(blankQuizzes);
    }
}
