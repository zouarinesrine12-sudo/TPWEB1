
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestAllListeners")
public class TestAllListeners extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        // ==================================
        // 1. TEST ACTIVE SESSION LISTENER
        // ==================================

        HttpSession session = request.getSession();

        // ==================================
        // 2. TEST SESSION ATTRIBUTE LISTENER
        // ==================================

        session.setAttribute("user", "Nesrine");

        session.setAttribute("user", "Ahmed");

        session.removeAttribute("user");

        // ==================================
        // 3. TEST APPLICATION ATTRIBUTE LISTENER
        // ==================================

        ServletContext context = getServletContext();

        context.setAttribute("appVersion", "1.0");

        context.setAttribute("appVersion", "2.0");

        context.removeAttribute("appVersion");

        // ==================================
        // 4. TEST REQUEST ATTRIBUTE LISTENER
        // ==================================

        request.setAttribute("message", "Bonjour");

        request.setAttribute("message", "Bienvenue");

        request.removeAttribute("message");

        // ==================================
        // 5. DISPLAY RESULT
        // ==================================

        response.getWriter().println(
            "<h2>Test de tous les Listeners terminé !</h2>"
        );

        response.getWriter().println(
            "<p>Consulte la console Tomcat pour voir les événements.</p>"
        );

        // ==================================
        // 6. TEST SESSION DESTRUCTION
        // ==================================

        session.invalidate();
    }
}
