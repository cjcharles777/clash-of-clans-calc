package app.initializer;

/**
 * Created by cedric on 12/3/14.
 */

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedGwt
{
    public static void main(String[] args) throws Throwable {

        // Create an embedded Jetty server on port 8080
        QueuedThreadPool threadPool=new QueuedThreadPool();
        threadPool.setMaxThreads(100);
        threadPool.setMinThreads(25);
        Server server = new Server(threadPool);
        HttpConfiguration http_config = new HttpConfiguration();

        ServerConnector http = new ServerConnector(server,
                new HttpConnectionFactory(http_config));
        http.setPort(8080);
        http.setIdleTimeout(30000);
        server.addConnector(http);


        // Create a handler for processing our GWT app
       // WebAppContext handler = new WebAppContext();
       // handler.setContextPath("/");
       // handler.setWar("./apps/GwtApplication.war");

        // If your app isn't packaged into a WAR, you can do this instead
        WebAppContext altHandler = new WebAppContext();
        altHandler.setResourceBase("./apps/GwtApplication");
        altHandler.setDescriptor("./apps/GwtApplication/WEB-INF/web.xml");
        altHandler.setContextPath("/");
        altHandler.setParentLoaderPriority(true);

        // Add it to the server
        server.setHandler(altHandler);

        // Other misc. options

       // server.setThreadPool(threadPool);
        server.setStopAtShutdown(true);

        // And start it up
        server.start();
        server.join();
    }
}
