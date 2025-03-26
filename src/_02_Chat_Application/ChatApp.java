package _02_Chat_Application;

import javax.swing.JOptionPane;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {

	Server server;
	Client client;
	private int port = 8080;
	private boolean isServer;

	public ChatApp() {
		int response = JOptionPane.showConfirmDialog(null, "Would you like to host a chat?", "Chat App",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			isServer = true;
			server = new Server(port);
			new Thread(() -> server.start()).start();
		} else {
			isServer = false;
			String ip = JOptionPane.showInputDialog("Enter server IP address:");
			client = new Client(ip, port);
			new Thread(() -> client.start()).start();
		}
	}

	public void chat(String msg) {
		if (isServer && server != null) {
			server.sendMessage(msg);
		} else if (!isServer && client != null) {
			client.sendMessage(msg);
		}
	}
	
	public boolean getIsServer() {
		return isServer;
	}
}
