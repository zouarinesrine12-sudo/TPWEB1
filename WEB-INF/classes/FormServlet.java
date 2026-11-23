import java.io.*;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormServlet extends HttpServlet {

    private void addCookie(HttpServletResponse response, String name, String value)
            throws UnsupportedEncodingException {
        Cookie c = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
        c.setMaxAge(24 * 60 * 60); // 1 jour
        response.addCookie(c);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
        String birthDay  = request.getParameter("birthDay");
        String sex       = request.getParameter("sex");

        addCookie(response, "firstName", firstName);
        addCookie(response, "lastName", lastName);
        addCookie(response, "birthDay", birthDay);
        addCookie(response, "sex", sex);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<table border='1'>");
        out.println("<tr><th>Prénom</th><td>" + firstName + "</td></tr>");
        out.println("<tr><th>Nom</th><td>" + lastName + "</td></tr>");
        out.println("<tr><th>Date de naissance</th><td>" + birthDay + "</td></tr>");
        out.println("<tr><th>Sexe</th><td>" + sex + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
    }
}