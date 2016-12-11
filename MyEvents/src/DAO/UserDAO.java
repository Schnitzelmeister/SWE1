package DAO;

import user.User;

/*
 * Erweiterung von UniversalDAO<User>, weil wir noch Clients bei userName organisieren
 */
public class UserDAO extends UniversalDAO<User> {
	private java.util.TreeMap<String, User> userByName;
	
	public UserDAO(String source) throws IllegalArgumentException {
		super(source);
		
		userByName = new java.util.TreeMap<String, User>();
		for (User u : super.getItems().values())
			userByName.put(u.getUsername(), u);
	}
	
	public User getUserbyUsername(String userName) throws IllegalArgumentException {
		if ( !userByName.containsKey(userName) )
			throw new IllegalArgumentException("User with name=" + userName + " doesn't exist");
		
		return userByName.get(userName);
	}
	
	/**
	 * Overriding of base Method
	 */
	public void speichereItem(User item) throws IllegalArgumentException {
		if ( item.getId() == -1 && userByName.containsKey(item.getUsername()) )
			throw new IllegalArgumentException("User with name=" + item.getUsername() + " exist. You can not add new User with existed Name");
		
		super.speichereItem(item);
	}
}
