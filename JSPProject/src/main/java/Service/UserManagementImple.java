package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.User;

public class UserManagementImple implements UserManagement {
	public Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspproject","root","root");
			} catch (Exception e) {
				e.printStackTrace();
			}
		return connection;
	}

	@Override
	public int saveUser(User u) {
		int rows=0;
		Connection con=getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO userdetails(Username,UserEmail,UserPassword,UserGender,UserState)VALUES(?,?,?,?,?)");
			
			ps.setString(1,u.getUsername());
			ps.setString(2,u.getUserEmail());
			ps.setString(3,u.getUserPassword());
			ps.setString(4,u.getUserGender());
			ps.setString(5,u.getUserState());
			
			rows=ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public boolean validateUser(String email, String password) {
		boolean status=false;	
		try {
		Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM userdetails WHERE UserEmail=? AND UserPassword=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public List<User> getAllUsers() {
	    List<User> list = new ArrayList<>();

	    try {
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM userdetails");
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            User u = new User();
	            u.setUserId(rs.getInt("UserId"));
	            u.setUsername(rs.getString("Username"));
	            u.setUserEmail(rs.getString("UserEmail"));
	            u.setUserPassword(rs.getString("UserPassword"));
	            u.setUserGender(rs.getString("UserGender"));
	            u.setUserState(rs.getString("UserState"));
	            list.add(u);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
	
	@Override
	public boolean deleteUser(int id) {
	    try {
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement("DELETE FROM userdetails WHERE UserId=?");
	        ps.setInt(1, id);
	        
	        int rows = ps.executeUpdate();
	        return rows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}



	@Override
	public User getUserById(int id) {
	    User u = null;
	    try {
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM userdetails WHERE UserId=?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            u = new User();
	            u.setUserId(rs.getInt("UserId"));
	            u.setUsername(rs.getString("Username"));
	            u.setUserEmail(rs.getString("UserEmail"));
	            u.setUserPassword(rs.getString("UserPassword"));
	            u.setUserGender(rs.getString("UserGender"));
	            u.setUserState(rs.getString("UserState"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return u;
	}

	
	@Override
	public boolean updateUser(User u) {
	    try {
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "UPDATE userdetails SET Username=?, UserEmail=?, UserPassword=?, UserGender=?, UserState=? WHERE UserId=?"
	        );
	        
	        ps.setString(1, u.getUsername());
	        ps.setString(2, u.getUserEmail());
	        ps.setString(3, u.getUserPassword());
	        ps.setString(4, u.getUserGender());
	        ps.setString(5, u.getUserState());
	        ps.setInt(6, u.getUserId());
	        
	        int rows = ps.executeUpdate();
	        return rows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}


}
