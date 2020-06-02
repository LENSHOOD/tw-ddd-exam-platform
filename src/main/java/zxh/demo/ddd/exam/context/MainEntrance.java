package zxh.demo.ddd.exam.context;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

/**
 * MainEntrance:
 * @author zhangxuhai
 * @date 2020/6/2
*/
public class MainEntrance {
    private static Vertx vertx = Vertx.vertx();

    public static void main(String[] args) {
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        router.route("/ddd/blank-quizzes").method(HttpMethod.GET).handler(
                req -> req.response().end("hello world")
        );

        server.requestHandler(router).listen(8080);
    }
}
