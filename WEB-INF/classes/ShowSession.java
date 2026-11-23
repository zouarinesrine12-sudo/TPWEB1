import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowSession extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        Integer count = (Integer) session.getAttribute("count");
        String message;

        if (count == null) {
            count = 0;
            message = "Welcome on my site";
        } else {
            message = "Welcome back";
        }
        count++;
        session.setAttribute("count", count);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>" + message + "</h3>");
        out.println("<p>Number of visits: " + count + "</p>");
        out.println("</body></html>");
    }
}