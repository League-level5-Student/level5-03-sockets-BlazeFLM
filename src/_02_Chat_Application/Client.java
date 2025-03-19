package _02_Chat_Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	private String ip;
	private int port;

	Socket sock;

	ObjectOutputStream oos;
	ObjectInputStream ois;

	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void start() {
		try {
			sock = new Socket(ip, port);

			oos = new ObjectOutputStream(sock.getOutputStream());
			ois = new ObjectInputStream(sock.getInputStream());

			oos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (sock.isConnected()) {
			try {
				JOptionPane.showMessageDialog(null, ois.readObject());
				System.out.println(ois.readObject());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

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
