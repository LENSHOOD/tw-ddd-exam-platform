package zxh.demo.ddd.exam.context.quizbank.application;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import zxh.demo.ddd.exam.context.quizbank.application.command.UpdateQuizBankCommand;
import zxh.demo.ddd.exam.context.quizbank.domain.model.quizbank.*;
import java.util.List;
import java.util.Optional;

class QuizBankOperationUseCaseTest {
    private QuizBankRepository repository = mock(QuizBankRepository.class);
    private QuizBankOperationUseCase useCase = new QuizBankOperationUseCase(repository);

    @Test
    void should_fail_when_QuizBank_not_found() {
        UpdateQuizBankCommand command = new UpdateQuizBankCommand(new QuizBankId("id"), null);
        when(repository.findById(any(QuizBankId.class))).thenReturn(Optional.empty());

        assertThrows(NoSuchQuizBankException.class, () -> useCase.updateQuizBank(command));
    }

    @Test
    void should_update_QuizBank() {
        // given
        QuizBankId id = new QuizBankId("id");
        List<BlankQuiz> blankQuizzes = Lists.newArrayList(new BlankQuiz("quiz1", "correct", 5));
        UpdateQuizBankCommand command = new UpdateQuizBankCommand(id, blankQuizzes);

        QuizBank quizBank = QuizBank.create(id, blankQuizzes);
        when(repository.findById(any(QuizBankId.class))).thenReturn(Optional.of(quizBank));
        doNothing().when(repository).save(any(QuizBank.class));

        // when
        useCase.updateQuizBank(command);

        // then
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(quizBank);
    }
}