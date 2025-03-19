package _02_Chat_Application;

import javax.swing.JOptionPane;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {

	Server server;
	Client client;
	private int port = 8080;
	
	public ChatApp() {
		int response = JOptionPane.showConfirmDialog(null, "Would you like to host the server?", "Chat App", JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION) {
			//server = new Server(port);
			//server.sendMessage("");
			server.start();
		} else {
			String ip = JOptionPane.showInputDialog("Enter server IP address:");
			client = new Client(ip, port);
			client.start();
		}
	}
	
	public void chat() {
		
	}
}
