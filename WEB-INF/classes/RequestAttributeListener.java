
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestAttributeListener
        implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("[REQUEST] Attribut ajouté : "
                + event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println("[REQUEST] Attribut modifié : "
                + event.getName() + " = "
                + event.getServletRequest().getAttribute(event.getName()));
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("[REQUEST] Attribut supprimé : "
                + event.getName() + " = " + event.getValue());
    }
}
