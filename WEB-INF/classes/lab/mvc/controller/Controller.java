package lab.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import lab.mvc.model.Person;

public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        // 1. Récupérer les informations du formulaire
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        // 2. Créer un objet Person
        Person person = new Person(firstName, lastName, birthDay, sex);

        // 3. Ajouter le bean à la requête
        request.setAttribute("person", person);

        // 4. Vérifier l'année de naissance
        int year = Integer.parseInt(birthDay);

        String page;

        if (year < 1990) {
            page = "/old.jsp";
        } else {
            page = "/young.jsp";
        }

        // 5. Transférer la requête vers la JSP appropriée
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(page);

        dispatcher.include(request, response);
    }
}
