package zxh.demo.ddd.exam.context.paper.infrastructure;

import com.google.common.collect.Maps;
import zxh.demo.ddd.exam.context.paper.domain.model.paper.Paper;
import zxh.demo.ddd.exam.context.paper.domain.model.paper.PaperId;
import zxh.demo.ddd.exam.context.paper.domain.model.paper.PaperRepository;
import java.util.ArrayList;
import java.util.List;
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

    public List<Paper> getAll() {
        return new ArrayList<>(paperDb.values());
    }
}
