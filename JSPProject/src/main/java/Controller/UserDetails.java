package Controller;

import java.io.IOException;
import java.util.List;

import Model.User;
import Service.UserManagementImple;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserDetails")
public class UserDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UserManagementImple m = new UserManagementImple();
        List<User> list = m.getAllUsers();

        req.setAttribute("users", list);
        req.getRequestDispatcher("viewAll.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doGet(req, resp); // reuse same logic
    }
}
