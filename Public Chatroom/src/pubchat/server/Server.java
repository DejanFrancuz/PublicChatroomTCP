package pubchat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import pubchat.observer.Notification;
import pubchat.observer.Publisher;
import pubchat.observer.Subscriber;

public class Server implements Publisher {

	private static Server SERVER;
	
	private List<Subscriber> subscribers = new ArrayList<>();
	
	private Server() throws IOException {
		super();
		@SuppressWarnings("resource") ServerSocket server = new ServerSocket(2021);
		while (true) {
			Socket socket = server.accept();
			ServerThread st = new ServerThread(this, socket);
			this.addSubscriber(st);
			Thread thread = new Thread(st);
			thread.start();
		}
	}
	
	public static Server getServer() throws IOException {
		if (SERVER == null) SERVER = new Server();
		return SERVER;
	}

	@Override
	public void addSubscriber(Subscriber sub) {		
		this.subscribers.add(sub);
	}

	@Override
	public void removeSubscriber(Subscriber sub) {
		this.subscribers.remove(sub);
	}

	@Override
	public void notifySubscribers(Notification notification) {		
		for (Subscriber sub: this.subscribers)
			sub.update(notification);
	}

}
