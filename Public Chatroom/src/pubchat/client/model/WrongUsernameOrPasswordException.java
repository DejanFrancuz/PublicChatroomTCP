package pubchat.client.model;

public class WrongUsernameOrPasswordException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String password;

	public WrongUsernameOrPasswordException(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public char[] getPasswordLengthArrayOfStars() {
		char[] res = new char[this.password.length()];
		for (int i = 0; i < res.length; ++i) res[i] = '*';
		return res;
	}
	
	@Override
	public String getMessage() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(super.getMessage());
		stringBuilder.append(" for username=");
		stringBuilder.append(this.username);
		stringBuilder.append(" and password=");
		stringBuilder.append(this.getPasswordLengthArrayOfStars());
		return stringBuilder.toString();
	}

}
