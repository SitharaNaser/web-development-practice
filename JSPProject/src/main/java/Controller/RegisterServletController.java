package Controller;

import java.io.IOException;

import Model.User;
import Service.UserManagementImple;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServletController")
public class RegisterServletController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String state=req.getParameter("state");
		
		User u=new User();
		u.setUsername(name);
		u.setUserEmail(email);
		u.setUserPassword(password);
		u.setUserGender(gender);
		u.setUserState(state);
		
		UserManagementImple m=new UserManagementImple();
		int result=m.saveUser(u);
		
		if(result>0) {
			resp.sendRedirect("login.jsp");
		}else {
			resp.sendRedirect("error.jsp");
		}
	}

}
