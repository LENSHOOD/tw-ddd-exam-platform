package zxh.demo.ddd.exam.domain.paper;

/**
 * PaperRepository:
 * @author zhangxuhai
 * @date 2020/5/8
*/
public interface PaperRepository {
    void save(Paper paper);

    PaperId nextId();
}
