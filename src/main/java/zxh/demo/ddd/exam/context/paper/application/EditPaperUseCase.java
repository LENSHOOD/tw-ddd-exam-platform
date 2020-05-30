package zxh.demo.ddd.exam.context.paper.application;

import zxh.demo.ddd.exam.context.paper.application.request.AssemblePaperRequest;
import zxh.demo.ddd.exam.context.paper.domain.model.paper.Paper;
import zxh.demo.ddd.exam.context.paper.domain.model.paper.PaperRepository;
import zxh.demo.ddd.exam.context.paper.infrastructure.PaperRepositoryImpl;

/**
 * PaperService:
 * @author zhangxuhai
 * @date 2020/5/8
*/
public class EditPaperUseCase {
    private final PaperRepository paperRepository;

    public EditPaperUseCase() {
        paperRepository = new PaperRepositoryImpl();
    }

    public void assemblePaper(AssemblePaperRequest request) {
        Paper paper = Paper.create(paperRepository.nextId(), request.getTeacherId(), request.getBlankQuizzes());
        paperRepository.save(paper);
    }
}
