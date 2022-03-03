package pubchat.client;

import java.io.IOException;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import pubchat.client.model.WrongUsernameOrPasswordException;
import pubchat.client.view.MainView;

public class ClientLauncher extends Application {
	
	private int i = 0;
	private Client cl;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.loop();
	}
	
	private void loop() throws UnknownHostException, IOException {
		++this.i;
		try {
			this.askForUsernameAndPassword();
		} catch (WrongUsernameOrPasswordException e) {
			if (this.i == 3) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("No more guesses");
				alert.setHeaderText(null);
				alert.setContentText("It seems like you have used all the guesses available");
			}
			this.loop();
		}
	}
	
	private void askForUsernameAndPassword() throws UnknownHostException, IOException, WrongUsernameOrPasswordException {
		TextInputDialog tid = new TextInputDialog();
		tid.showAndWait();
		String username = tid.getResult();
		MainView main = new MainView(username);
		this.cl = new Client(main.getTvMessages());
		main.setWebClient(cl);
		main.show();
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		this.cl.sendMessage("a\ta\tQUIT");
	}

}
