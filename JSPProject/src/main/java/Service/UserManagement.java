package Service;

import java.util.List;

import Model.User;

public interface UserManagement {
	public int saveUser(User u);
	public boolean validateUser(String email,String password);
	public List<User> getAllUsers();
	public boolean deleteUser(int id);
	public User getUserById(int id);
	public boolean updateUser(User u);

	

}
