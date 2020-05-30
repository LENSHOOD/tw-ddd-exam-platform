package zxh.demo.ddd.exam.context.paper.application;

import zxh.demo.ddd.exam.context.paper.application.request.AssemblePaperRequest;
import zxh.demo.ddd.exam.context.paper.domain.model.paper.PaperService;
import zxh.demo.ddd.exam.context.paper.infrastructure.PaperRepositoryImpl;

/**
 * PaperService:
 * @author zhangxuhai
 * @date 2020/5/8
*/
public class EditPaperUseCase {
    private final PaperService paperService;

    public EditPaperUseCase() {
        this.paperService = new PaperService(new PaperRepositoryImpl());
    }

    public void assemblePaper(AssemblePaperRequest request) {
        paperService.create(request.getTeacherId(), request.getBlankQuizzes());
    }
}
