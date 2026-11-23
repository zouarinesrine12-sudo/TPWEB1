import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListItems extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        showItems(request, response, true);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        showItems(request, response, false);
    }

    private void showItems(HttpServletRequest request,
                           HttpServletResponse response,
                           boolean addNewItem)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            HttpSession session = request.getSession(true);

            Object savedItems = session.getAttribute("items");
            ArrayList<String> items;

            if (savedItems instanceof ArrayList<?>) {
                @SuppressWarnings("unchecked")
                ArrayList<String> existingItems =
                        (ArrayList<String>) savedItems;
                items = existingItems;
            } else {
                items = new ArrayList<String>();
            }

            if (addNewItem) {
                String newItem = request.getParameter("newItem");

                if (newItem != null && !newItem.trim().isEmpty()) {
                    items.add(newItem.trim());
                }
            }

            session.setAttribute("items", items);

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Items in your session</h3>");
            out.println("<ul>");

            for (String item : items) {
                out.println("<li>" + escapeHtml(item) + "</li>");
            }

            out.println("</ul>");
            out.println("<a href='items.html'>Add another item</a>");
            out.println("</body></html>");

        } catch (IllegalStateException e) {
            log("La session n'est plus disponible.", e);
            response.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "La session n'est plus disponible."
            );
        }
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}