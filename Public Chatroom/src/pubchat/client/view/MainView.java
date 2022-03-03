package pubchat.client.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import pubchat.client.Client;

public class MainView extends Stage {
	
	private Client webClient;
	
	private MessageTable tvMessages;
	
	private Button btClose = new Button("Close");
	
	private Button btSend = new Button("Send");
	
	private TextField taMessage = new TextField();
	
	public MainView(String username) {
		super();
		super.setTitle(username);
		this.tvMessages = new MessageTable();
		HBox hbTop = new HBox(10, this.btClose, this.btSend);
		hbTop.setAlignment(Pos.CENTER);
		this.btClose.setOnAction(e -> {
			this.close();
			this.webClient.sendMessage(username + "\ta\tQUIT");
			System.exit(0);
		});
		this.btSend.setOnAction(e -> {
			this.webClient.sendMessage(username + "\t" + this.taMessage.getText() + "\tNEW");
		});
		BorderPane root = new BorderPane(this.tvMessages, hbTop, null, this.taMessage, null);
		root.setPadding(new Insets(10));
		super.setScene(new Scene(root));
	}
	
	public Client getWebClient() {
		return webClient;
	}
	
	public void setWebClient(Client webClient) {
		this.webClient = webClient;
	}

	public MessageTable getTvMessages() {
		return this.tvMessages;
	}

}
