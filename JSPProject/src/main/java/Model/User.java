package Model;

public class User {
	private int UserId;
	private String Username;
	private String UserEmail;
	private String UserPassword;
	private String UserGender;
	private String UserState;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserGender() {
		return UserGender;
	}
	public void setUserGender(String userGender) {
		UserGender = userGender;
	}
	public String getUserState() {
		return UserState;
	}
	public void setUserState(String userState) {
		UserState = userState;
	}
	public User(int userId, String username, String userEmail, String userPassword, String userGender,
			String userState) {
		super();
		UserId = userId;
		Username = username;
		UserEmail = userEmail;
		UserPassword = userPassword;
		UserGender = userGender;
		UserState = userState;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
