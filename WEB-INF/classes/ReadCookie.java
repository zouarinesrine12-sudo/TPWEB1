import java.io.*;
import java.net.URLDecoder;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String firstName = "", lastName = "", birthDay = "", sex = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                String v = URLDecoder.decode(c.getValue(), "UTF-8");
                if (c.getName().equals("firstName")) firstName = v;
                else if (c.getName().equals("lastName")) lastName = v;
                else if (c.getName().equals("birthDay")) birthDay = v;
                else if (c.getName().equals("sex")) sex = v;
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Valeurs lues depuis les cookies</h3>");
        out.println("<table border='1'>");
        out.println("<tr><th>Prénom</th><td>" + firstName + "</td></tr>");
        out.println("<tr><th>Nom</th><td>" + lastName + "</td></tr>");
        out.println("<tr><th>Date de naissance</th><td>" + birthDay + "</td></tr>");
        out.println("<tr><th>Sexe</th><td>" + sex + "</td></tr>");
        out.println("</table>");
        out.println("<a href='form.html'>Retour</a>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}