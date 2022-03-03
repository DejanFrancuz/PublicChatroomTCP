package pubchat.client.model;

import java.util.HashMap;
import java.util.Map;

public class PasswordValidator {
	
	private static Map<String, String> USERS = new HashMap<>();
	
	static {
		
	}
	
	public static boolean userExists(String username) {
		return USERS.get(username) != null;
	}
	
	public static boolean validate(String username, String password) {
		if (userExists(username))
			return USERS.get(username).equals(password);
		return false;
	}
	
	public static boolean addUser(String username, String password) {
		if (!userExists(username)) {
			USERS.put(username, password);
			return true;
		}
		return false;
	}

}
