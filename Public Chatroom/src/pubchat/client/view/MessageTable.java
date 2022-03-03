package pubchat.client.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pubchat.client.model.Message;

public class MessageTable extends TableView<Message> {

	public MessageTable() {
		super(FXCollections.observableArrayList());
		TableColumn<Message, String> tcUsername = new TableColumn<>("Sender");
		TableColumn<Message, String> tcMessage = new TableColumn<>("Message");
		tcUsername.setCellValueFactory(new PropertyValueFactory<>("senderUsername"));
		tcMessage.setCellValueFactory(new PropertyValueFactory<>("content"));
		this.getColumns().add(tcUsername);
		this.getColumns().add(tcMessage);
	}

}
