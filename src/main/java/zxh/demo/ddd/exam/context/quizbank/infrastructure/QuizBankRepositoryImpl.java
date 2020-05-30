package zxh.demo.ddd.exam.context.quizbank.infrastructure;

import zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank.QuizBank;
import zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank.QuizBankId;
import zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank.QuizBankRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * QuizBankRepositoryImpl:
 * @author zhangxuhai
 * @date 2020/5/30
*/
public class QuizBankRepositoryImpl implements QuizBankRepository {
    private Map<QuizBankId, QuizBank> db = new HashMap<>();

    @Override
    public Optional<QuizBank> findById(QuizBankId id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public void save(QuizBank quizBank) {
        db.put(quizBank.getId(), quizBank);
    }
}
