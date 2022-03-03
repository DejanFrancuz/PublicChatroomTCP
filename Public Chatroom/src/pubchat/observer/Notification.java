package pubchat.observer;

public class Notification {

	private final String sender;
	
	private final String content;
	
	private final NotificationType type;

	public Notification(String sender, String content, NotificationType type) {
		super();
		this.sender = sender;
		this.content = content;
		this.type = type;
	}

	public String getSender() {
		return sender;
	}

	public String getContent() {
		return content;
	}
	
	public NotificationType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return this.sender + "\t" + this.content + "\t" + this.type;
	}
	
}
