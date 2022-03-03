package pubchat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import pubchat.observer.Notification;
import pubchat.observer.NotificationType;
import pubchat.observer.Subscriber;

public class ServerThread implements Runnable, Subscriber {
		
	private Server server;
	
	private Socket socket;
	
	private BufferedReader in;
	
	private PrintWriter out;
	
	private boolean quit = false;

	private String s;

	public ServerThread(Server server, Socket socket) throws IOException {
		super();
		this.server = server;
		this.socket = socket;
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
	}

	@Override
	public void run() {
		while (!this.quit) {
			try {
				String[] a = this.in.readLine().split("\t");
				s = a[0];
				this.server.notifySubscribers(new Notification(a[0], a[1], NotificationType.valueOf(a[2])));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Notification notification) {		
		if (notification.getType() == NotificationType.QUIT) {
			if (!notification.getSender().equals(s))
				return;
			this.quit = true;
			return;
		}
		this.out.println(notification.toString());
	}

}
