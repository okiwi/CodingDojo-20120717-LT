import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.impl.DefaultVertx;
import org.vertx.java.deploy.Verticle;

public class Server extends Verticle {

	public void start() {
		new DefaultVertx().createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
			public void handle(HttpServerRequest req) {
				req.response.headers().put("Content-Type", "text/html; charset=UTF-8");
				req.response.end("<html><body>Hello world Okiwi!</body></html>");
			}
		}).listen(8080);
	}
}