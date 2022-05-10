import com.sun.net.httpserver.HttpServer;

import javax.xml.xpath.XPath;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Handler;

public class SimpleHttpServer {
    public static int DEFAULT_PORT = 9000;
    public static int port;
    private HttpServer httpServer;
    private void start(int port){
        this.port = port;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), 0);
            System.out.println("server started at " + port);
            httpServer.createContext("/", new Handlers.RootHandler());
            httpServer.createContext("/echoHandler", new Handlers.EchoHeaderHandler());
          //  httpServer.createContext("/echoGet", new Handlers.EchoHeaderHandler());
            //httpServer.createContext("/echoPost", new Handlers.EchoPostHandler());
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

public static void main(String[] args){
    SimpleHttpServer httpServer = new SimpleHttpServer();
    httpServer.start(DEFAULT_PORT);
}
}