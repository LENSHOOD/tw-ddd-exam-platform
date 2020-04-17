package zxh.demo.ddd.exam.domain.paper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Paper:
 * @author zhangxuhai
 * @date 2020/4/17
*/
public class Paper {
    public static final int MIN_QUIZZES = 5;
    public static final int MAX_QUIZZES = 20;
    private PaperId id;
    private String teacherId;
    private List<BlankQuiz> blankQuizzes;

    private Paper(PaperId paperId, String teacherId, List<BlankQuiz> blankQuizzes) {
        this.id = paperId;
        this.teacherId = teacherId;
        this.blankQuizzes = blankQuizzes;
    }

    public static Paper create(PaperId paperId, String teacherId, List<BlankQuiz> blankQuizzes) {
        List<BlankQuiz> distinctBlankQuizzes = blankQuizzes.stream().distinct().collect(Collectors.toList());
        if (distinctBlankQuizzes.size() < MIN_QUIZZES) {
            throw new IllegalArgumentException("Given quizzes less than 5.");
        }

        if (distinctBlankQuizzes.size() > MAX_QUIZZES) {
            throw new IllegalArgumentException("Given quizzes more than 20.");
        }

        return new Paper(paperId, teacherId, distinctBlankQuizzes);
    }
}
