package zxh.demo.ddd.exam.context.quizbank.application;

import zxh.demo.ddd.exam.context.quizbank.application.command.UpdateQuizBankCommand;
import zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank.NoSuchQuizBankException;
import zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank.QuizBank;
import zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank.QuizBankRepository;

/**
 * QuizBankOperationUseCase:
 * @author zhangxuhai
 * @date 2020/5/30
*/
public class QuizBankOperationUseCase {
    private final QuizBankRepository quizBankRepository;

    public QuizBankOperationUseCase(QuizBankRepository quizBankRepository) {
        this.quizBankRepository = quizBankRepository;
    }


    public void updateQuizBank(UpdateQuizBankCommand command) {
        QuizBank quizBank = quizBankRepository.findById(command.getId()).orElseThrow(NoSuchQuizBankException::new);
        quizBank.update(command.getBlankQuizzes());
        quizBankRepository.save(quizBank);
    }
}
