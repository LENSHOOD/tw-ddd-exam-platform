package zxh.demo.ddd.exam.context;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import zxh.demo.ddd.exam.context.paper.userinterface.PaperApiHandler;

/**
 * MainEntrance:
 * @author zhangxuhai
 * @date 2020/6/2
*/
public class MainEntrance {
    private static Vertx vertx = Vertx.vertx();

    public static void main(String[] args) {
        new MainEntrance().startServer();
    }

    private void startServer() {
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        registerHandler(router);

        server.requestHandler(router).listen(8080);
    }

    private void registerHandler(Router router) {
        new PaperApiHandler().handle(router);
    }
}
