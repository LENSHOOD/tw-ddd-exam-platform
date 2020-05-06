package zxh.demo.ddd.exam.domain.answersheet;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import zxh.demo.ddd.exam.domain.paper.BlankQuiz;

/**
 * AnswerSheet:
 * @author zhangxuhai
 * @date 2020/5/6
*/
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AnswerSheet {
    private AnswerSheetId id;
    private String studentId;
    private int score;
    private boolean isHandIn;
    private boolean isSendOut;

    public static AnswerSheet create(AnswerSheetId id, String studentId) {
        return new AnswerSheet(id, studentId, 0, false, false);
    }

    public void handIn() {
        if (isHandIn) {
            throw new UnsupportedOperationException("Cannot hand in twice.");
        }
        isHandIn = true;
    }

    public void sendOut() {
        if (!isHandIn) {
            throw new UnsupportedOperationException("Cannot send out before hand in.");
        }

        isSendOut = true;
    }

    public void submit(BlankQuiz quiz, String answer) {
        if (!canSubmit()) {
            throw new UnsupportedOperationException(
                    "Cannot submit because the answer sheet haven't hand in or already send out");
        }
        score = quiz.judgeAnswer(answer);
    }

    private boolean canSubmit() {
        return isHandIn && !isSendOut;
    }
}
