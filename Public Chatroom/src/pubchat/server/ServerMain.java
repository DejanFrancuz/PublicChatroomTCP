package pubchat.server;

import java.io.IOException;

public class ServerMain {
	public static void main(String[] args) {
		try {
			Server.getServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
