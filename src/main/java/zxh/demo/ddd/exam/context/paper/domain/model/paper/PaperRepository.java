package zxh.demo.ddd.exam.context.paper.domain.model.paper;

/**
 * PaperRepository:
 * @author zhangxuhai
 * @date 2020/5/8
*/
public interface PaperRepository {
    void save(Paper paper);

    PaperId nextId();
}
