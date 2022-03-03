package pubchat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.scene.control.TableView;
import pubchat.client.model.Message;

public class Client {

	private Socket socket;
	
	private BufferedReader in;
	
	private PrintWriter out;
	
	public Client(TableView<Message> table) throws UnknownHostException, IOException {
		super();
		this.socket = new Socket("localhost", 2021);
		this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		this.out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()), true);
		ClientThread th = new ClientThread(this.in, table);
		Thread thread = new Thread(th);
		thread.start();
	}
	
	public void sendMessage(String message) {
		this.out.println(message);
	}

}
