package zxh.demo.ddd.exam.domain.paper;

import java.util.List;

/**
 * Paper:
 * @author zhangxuhai
 * @date 2020/4/17
*/
public class Paper {
    private PaperId id;
    private String teacherId;
    private List<BlankQuiz> blankQuizzes;

    private Paper(PaperId paperId, String teacherId, List<BlankQuiz> blankQuizzes) {
        this.id = paperId;
        this.teacherId = teacherId;
        this.blankQuizzes = blankQuizzes;
    }

    public static Paper create(PaperId paperId, String teacherId, List<BlankQuiz> blankQuizzes) {
        return new Paper(paperId, teacherId, blankQuizzes);
    }
}
