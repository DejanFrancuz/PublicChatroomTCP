package pubchat.client.model;

public class Message {
	
	private String senderUsername;
	
	private String content;

	public Message(String senderUsername, String content) {
		super();
		this.senderUsername = senderUsername;
		this.content = content;
	}

	public String getSenderUsername() {
		return senderUsername;
	}

	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
