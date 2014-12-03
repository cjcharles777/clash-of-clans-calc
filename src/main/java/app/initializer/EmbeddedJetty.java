package app.initializer;

import org.apache.jasper.servlet.JspServlet;
import org.eclipse.jetty.annotations.ServletContainerInitializersStarter;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.plus.annotation.ContainerInitializer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cedric on 12/3/14.
 */
public class EmbeddedJetty
{
    private static final int DEFAULT_PORT = 8080;
    private static final String CONTEXT_PATH = "/";
    private static final String CONFIG_LOCATION = "app.config";
    private static final String MAPPING_URL = "/";
    private static final String DEFAULT_PROFILE = "dev";

    public static void main(String[] args) throws Exception
    {

        new EmbeddedJetty().startJetty(getPortFromArgs(args));


    }

    private static int getPortFromArgs(String[] args) {
        if (args.length > 0) {
            try {
                return Integer.valueOf(args[0]);
            } catch (NumberFormatException ignore) {
            }
        }
        return DEFAULT_PORT;
    }

    private void startJetty(int port) throws Exception {
        Server server = new Server(port);
        WebAppContext context = getServletContextHandler(getContext());
        setupJspHandler(context);
        server.setHandler(context);
        server.start();
        server.join();
        startBrowser();
    }

    private static void startBrowser() throws URISyntaxException, IOException
    {
        Desktop d= Desktop.getDesktop();

        // Browse a URL, say google.com
        d.browse(new URI("http://localhost:8080"));

    }

    private static WebAppContext getServletContextHandler(WebApplicationContext context) throws IOException {
        WebAppContext contextHandler = new WebAppContext();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath(CONTEXT_PATH);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
        contextHandler.addEventListener(new ContextLoaderListener(context));
        contextHandler.setResourceBase(new ClassPathResource("webapp").getURI().toString());

        return contextHandler;
    }

    private static WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        context.getEnvironment().setDefaultProfiles(DEFAULT_PROFILE);

        return context;
    }

    private void setupJspHandler(WebAppContext context) throws URISyntaxException {

        //Ensure the jsp engine is initialized correctly
        JettyJasperInitializer sci = new JettyJasperInitializer();

        ServletContainerInitializersStarter sciStarter = new ServletContainerInitializersStarter(context);
        ContainerInitializer initializer = new ContainerInitializer(sci, null);
        List<ContainerInitializer> initializers = new ArrayList<ContainerInitializer>();
        initializers.add(initializer);
        context.setAttribute("org.eclipse.jetty.containerInitializers", initializers);
        context.addBean(sciStarter, true);

        // Set Classloader of Context to be sane (needed for JSTL)
        // JSP requires a non-System classloader, this simply wraps the
        // embedded System classloader in a way that makes it suitable
        // for JSP to use
        ClassLoader jspClassLoader = new URLClassLoader(new URL[0], this.getClass().getClassLoader());
        context.setClassLoader(jspClassLoader);

        // Add JSP Servlet (must be named "jsp")
        ServletHolder holderJsp = new ServletHolder("jsp",JspServlet.class);
        holderJsp.setInitOrder(0);
        holderJsp.setInitParameter("logVerbosityLevel","INFO");
        holderJsp.setInitParameter("fork","false");
        holderJsp.setInitParameter("xpoweredBy","false");
        holderJsp.setInitParameter("compilerTargetVM","1.7");
        holderJsp.setInitParameter("compilerSourceVM","1.7");
        holderJsp.setInitParameter("keepgenerated","true");
        context.addServlet(holderJsp, "*.jsp");
        /**
        URL indexUri = this.getClass().getResource("/webapp/WEB-INF/views/");
        URI baseUri = indexUri.toURI();
        // Add Default Servlet (must be named "default")
        ServletHolder holderDefault = new ServletHolder("default",DefaultServlet.class);
       // LOG.info("Base URI: " + baseUri);
        holderDefault.setInitParameter("resourceBase",baseUri.toASCIIString());
        holderDefault.setInitParameter("dirAllowed","true");
        context.addServlet(holderDefault,"/*");
         **/
    }

}
