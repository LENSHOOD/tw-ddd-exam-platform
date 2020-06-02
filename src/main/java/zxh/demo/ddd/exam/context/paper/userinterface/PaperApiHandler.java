package zxh.demo.ddd.exam.context.paper.userinterface;

import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import zxh.demo.ddd.exam.context.paper.infrastructure.PaperRepositoryImpl;

/**
 * PaperApiHandler:
 * @author zhangxuhai
 * @date 2020/6/2
*/
public class PaperApiHandler {
    private final PaperRepositoryImpl repository;

    public PaperApiHandler() {
        this.repository = new PaperRepositoryImpl();
    }

    public void handle(Router router) {
        router.route("/ddd/papers")
                .method(HttpMethod.GET)
                .handler(req -> req.response().end(Json.encode(repository.getAll())));
    }
}
