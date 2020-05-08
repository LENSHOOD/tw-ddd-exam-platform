package zxh.demo.ddd.exam.application;

import zxh.demo.ddd.exam.application.request.AssemblePaperRequest;
import zxh.demo.ddd.exam.domain.paper.PaperRepository;
import zxh.demo.ddd.exam.domain.paper.PaperService;

/**
 * PaperService:
 * @author zhangxuhai
 * @date 2020/5/8
*/
public class EditPaperUseCase {
    private final PaperService paperService;

    public EditPaperUseCase(PaperRepository paperRepository) {
        this.paperService = new PaperService(paperRepository);
    }

    public void assemblePaper(AssemblePaperRequest request) {
        paperService.create(request.getTeacherId(), request.getBlankQuizzes());
    }
}
