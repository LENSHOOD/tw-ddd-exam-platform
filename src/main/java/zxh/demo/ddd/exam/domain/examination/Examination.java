package zxh.demo.ddd.exam.domain.examination;

import static java.util.Objects.isNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import zxh.demo.ddd.exam.domain.paper.Paper;
import java.util.ArrayList;
import java.util.List;

/**
 * Examination:
 * @author zhangxuhai
 * @date 2020/5/6
*/
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Examination {
    private ExaminationId id;
    private String teacherId;
    private List<String> studentIds;
    private Paper paper;

    public static Examination create(ExaminationId id, String teacherId) {
        return new Examination(id, teacherId, new ArrayList<>(), null);
    }

    public void addPaper(Paper paper) {
        if (isNull(paper)) {
            throw new NullPointerException("Paper cannot null.");
        }
        this.paper = paper;
    }

    public void addStudent(String studentId) {
        if (isNull(studentId)) {
            throw new NullPointerException("Student id cannot null.");
        }
        studentIds.add(studentId);
    }
}
