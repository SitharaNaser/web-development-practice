package Controller;

import java.io.IOException;

import Model.User;
import Service.UserManagementImple;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        UserManagementImple m = new UserManagementImple();
        User u = m.getUserById(id);

        req.setAttribute("user", u);
        req.getRequestDispatcher("editUser.jsp").forward(req, resp);
    }
}

