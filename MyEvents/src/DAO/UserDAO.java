package DAO;

import java.util.ArrayList;
import user.User;

public interface UserDAO {
	public void saveUser(User user);
	public void deleteUser(User user);
	public void overrideUser(User user);	
	public ArrayList<User> getAllUserList();
}
