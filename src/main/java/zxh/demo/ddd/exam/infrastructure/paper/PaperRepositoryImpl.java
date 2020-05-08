package zxh.demo.ddd.exam.infrastructure.paper;

import com.google.common.collect.Maps;
import zxh.demo.ddd.exam.domain.paper.Paper;
import zxh.demo.ddd.exam.domain.paper.PaperId;
import zxh.demo.ddd.exam.domain.paper.PaperRepository;
import java.util.Map;
import java.util.UUID;

/**
 * PaperRepositoryImpl:
 * @author zhangxuhai
 * @date 2020/5/8
*/
public class PaperRepositoryImpl implements PaperRepository {
    private final Map<PaperId, Paper> paperDb = Maps.newHashMap();

    @Override
    public void save(Paper paper) {
        paperDb.put(paper.getId(), paper);
    }

    @Override
    public PaperId nextId() {
        return new PaperId(UUID.randomUUID().toString());
    }
}
