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
	
	public boolean usernameAlreadyUsed(String userName){
		return userByName.containsKey(userName);
	}
	
	/**
	 * Overriding of base Method
	 */
	public void speichereItem(User item) throws IllegalArgumentException {
		boolean new_item = (item.getId() == -1);
		
		if ( new_item && userByName.containsKey(item.getUsername()) )
			throw new IllegalArgumentException("User with name=" + item.getUsername() + " exist. You can not add new User with existed Name");
		
		super.speichereItem(item);
		
		if (new_item)
			userByName.put(item.getUsername(), item);
	}
	
	/**
	 * Overriding of base Method
	 */
	public void loescheItem(User item) throws IllegalArgumentException {
		if ( !userByName.containsKey(item.getUsername()) )
			throw new IllegalArgumentException("User with name=" + item.getUsername() + " doesn't exist");

		super.loescheItem(item);
		userByName.remove(item);
	}
}
