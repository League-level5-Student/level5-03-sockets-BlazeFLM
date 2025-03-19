package _02_Chat_Application;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Server {
	private int port;
	
	private ServerSocket server;
	private Socket sock;

	ObjectOutputStream oos;
	ObjectInputStream ois;

	public Server(int port) {
		this.port = port;
	}

	public void start() {
		try {
			server = new ServerSocket(port, 100);
			sock = server.accept();

			oos = new ObjectOutputStream(sock.getOutputStream());
			ois = new ObjectInputStream(sock.getInputStream());

			oos.flush();

			while (sock.isConnected()) {
				try {
					JOptionPane.showMessageDialog(null, ois.readObject());
					System.out.println(ois.readObject());
				} catch (EOFException e) {
					JOptionPane.showMessageDialog(null, "Connection Lost");
					System.exit(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getIPAddress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			return "Error";
		}
	}
	
	public int getPort() {
		return port;
	}
	
	public void sendMessage(String message) { 
		try {
			if (oos != null) {
				oos.writeObject(message);
				oos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
