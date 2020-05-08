package zxh.demo.ddd.exam.application;

import zxh.demo.ddd.exam.application.request.AssemblePaperRequest;
import zxh.demo.ddd.exam.domain.paper.PaperService;
import zxh.demo.ddd.exam.infrastructure.paper.PaperRepositoryImpl;

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
