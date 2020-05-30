package zxh.demo.ddd.exam.context.paper.application.request;

import lombok.Data;
import zxh.demo.ddd.exam.context.paper.domain.model.paper.BlankQuiz;
import java.util.List;

/**
 * AssemblePaperRequest:
 * @author zhangxuhai
 * @date 2020/5/8
*/
@Data
public class AssemblePaperRequest {
    private String teacherId;
    private List<BlankQuiz> blankQuizzes;
}
