package zxh.demo.ddd.exam.context.answersheet.domain.model.answersheet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import zxh.demo.ddd.exam.context.paper.domain.model.paper.BlankQuiz;

class AnswerSheetTest {
    @Test
    void should_create_answer_sheet() {
        AnswerSheet answerSheet = AnswerSheet.create(new AnswerSheetId(), "student-id");

        assertThat(answerSheet, notNullValue());
    }

    @Test
    void should_hand_in() {
        AnswerSheet answerSheet = AnswerSheet.create(new AnswerSheetId(), "student-id");

        answerSheet.handIn();

        assertTrue(answerSheet.isHandIn());
    }

    @Test
    void should_fail_when_try_hand_in_twice() {
        AnswerSheet answerSheet = AnswerSheet.create(new AnswerSheetId(), "student-id");

        answerSheet.handIn();
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, answerSheet::handIn);

        assertThat(exception.getMessage(), is("Cannot hand in twice."));
    }

    @Test
    void should_send_out() {
        AnswerSheet answerSheet = AnswerSheet.create(new AnswerSheetId(), "student-id");

        answerSheet.handIn();
        answerSheet.sendOut();

        assertTrue(answerSheet.isSendOut());
    }

    @Test
    void should_fail_when_try_send_out_before_hand_in() {
        AnswerSheet answerSheet = AnswerSheet.create(new AnswerSheetId(), "student-id");

        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, answerSheet::sendOut);

        assertThat(exception.getMessage(), is("Cannot send out before hand in."));
    }

    @Test
    void should_submit_right_answer_to_get_score() {
        AnswerSheet answerSheet = AnswerSheet.create(new AnswerSheetId(), "student-id");

        answerSheet.handIn();
        answerSheet.submit(new BlankQuiz("q1", "a1", 5), "a1");

        assertThat(answerSheet.getScore(), is(5));
    }

    @Test
    void should_fail_when_try_submit_before_hand_in() {
        AnswerSheet answerSheet = AnswerSheet.create(new AnswerSheetId(), "student-id");

        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () ->
                answerSheet.submit(new BlankQuiz("q1", "a1", 5), "a1"));

        assertThat(exception.getMessage(), is("Cannot submit because the answer sheet haven't hand in or already send out"));
    }

    @Test
    void should_fail_when_try_submit_after_send_out() {
        AnswerSheet answerSheet = AnswerSheet.create(new AnswerSheetId(), "student-id");

        answerSheet.handIn();
        answerSheet.sendOut();
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () ->
                answerSheet.submit(new BlankQuiz("q1", "a1", 5), "a1"));

        assertThat(exception.getMessage(), is("Cannot submit because the answer sheet haven't hand in or already send out"));
    }
}