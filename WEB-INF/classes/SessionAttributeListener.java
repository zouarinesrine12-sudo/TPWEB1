
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("[SESSION ATTRIBUTE] Attribut ajouté : "
                + event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("[SESSION ATTRIBUTE] Attribut modifié : "
                + event.getName() + " = " + event.getSession().getAttribute(event.getName()));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("[SESSION ATTRIBUTE] Attribut supprimé : "
                + event.getName() + " = " + event.getValue());
    }
}
