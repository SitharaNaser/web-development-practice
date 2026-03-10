package Controller;

import java.io.IOException;

import Service.UserManagementImple;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServletController")
public class LoginServletController extends HttpServlet {
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	UserManagementImple m=new UserManagementImple();
	boolean valid=m.validateUser(email,password);
	if(valid) {
		resp.sendRedirect("success.jsp");
	}else {
		resp.sendRedirect("error.jsp");
	}
}

}
