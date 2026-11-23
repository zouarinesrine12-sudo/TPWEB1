import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CountVisits extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int visits = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visits")) {
                    try { visits = Integer.parseInt(c.getValue()); }
                    catch (NumberFormatException e) { visits = 0; }
                }
            }
        }
        visits++;

        Cookie c = new Cookie("visits", String.valueOf(visits));
        c.setMaxAge(365 * 24 * 60 * 60); // 1 an
        response.addCookie(c);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (visits == 1) out.println("<h3>Bienvenue sur mon site</h3>");
        else out.println("<h3>Bon retour</h3>");
        out.println("<p>Nombre de visites : " + visits + "</p>");
        out.println("</body></html>");
    }
}