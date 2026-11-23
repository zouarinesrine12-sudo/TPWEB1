
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    public static int activeUsers = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeUsers++;

        se.getSession().getServletContext()
          .setAttribute("activeUsers", activeUsers);

        System.out.println("Total actifs : " + activeUsers);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeUsers--;

        se.getSession().getServletContext()
          .setAttribute("activeUsers", activeUsers);

        System.out.println("[SESSION] Session détruite. Total actifs : "
                           + activeUsers);
    }
}
