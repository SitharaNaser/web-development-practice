package Controller;

import java.io.IOException;

import Service.UserManagementImple;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        UserManagementImple m = new UserManagementImple();
        m.deleteUser(id);

        // Redirect back to user list
        resp.sendRedirect("UserDetails");
    }
}
