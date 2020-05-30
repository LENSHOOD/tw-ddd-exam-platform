package zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank;

import java.util.Optional;

/**
 * QuizBankRepository:
 * @author zhangxuhai
 * @date 2020/5/30
*/
public interface QuizBankRepository {
    Optional<QuizBank> findById(QuizBankId id);

    void save(QuizBank quizBank);
}
