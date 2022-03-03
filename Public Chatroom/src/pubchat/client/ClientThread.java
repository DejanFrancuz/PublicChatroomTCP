package pubchat.client;

import java.io.BufferedReader;
import java.io.IOException;

import javafx.scene.control.TableView;
import pubchat.client.model.Message;

public class ClientThread implements Runnable {
	
	private BufferedReader in;
	private TableView<Message> table;
	
	public ClientThread(BufferedReader in, TableView<Message> table) {
		super();
		this.in = in;
		this.table = table;
	}

	@Override
	public void run() {		
		while (true) {
			try {
				String[] line = this.in.readLine().split("\t");
				if (line[2].equals("QUIT")) break;
				this.table.getItems().add(new Message(line[0], line[1]));
				this.table.refresh();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
			}
		}
	}

}
