package zxh.demo.ddd.exam.domain.paper;

import java.util.List;

/**
 * PaperService:
 * @author zhangxuhai
 * @date 2020/5/8
*/
public class PaperService {
    private final PaperRepository paperRepository;

    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public void create(String teacherId, List<BlankQuiz> blankQuizzes) {
        Paper paper = Paper.create(paperRepository.nextId(), teacherId, blankQuizzes);
        paperRepository.save(paper);
    }
}
