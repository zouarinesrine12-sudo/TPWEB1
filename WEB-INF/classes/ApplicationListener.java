
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("Application started!");

        ServletContext context = sce.getServletContext();

        context.setAttribute("appName", "ING1 Web Application");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("Application stopped!");
    }
}
