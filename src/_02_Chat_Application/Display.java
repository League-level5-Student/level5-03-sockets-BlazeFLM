package _02_Chat_Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Display implements ActionListener {

	JFrame frame;
	JPanel panel;
	JTextField field;
	JButton button;
	JTextArea textArea;

	ChatApp app;

	public Display() {
		app = new ChatApp();

		frame = new JFrame("Simple Chat Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		field = new JTextField(20);
		button = new JButton("Send");
		textArea = new JTextArea(10, 20);
		textArea.setEditable(false);
		button.addActionListener(this);

		panel.add(field);
		panel.add(button);
		panel.add(textArea);

		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}

	public void updateChat(String msg) {
		textArea.append(msg + "\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button)) {
			if (!field.getText().isEmpty() && app != null) {
				if (app.getIsServer()) {
					app.server.sendMessage("Server: " + field.getText());
					updateChat("Server: " + field.getText());
					field.setText(null);//issue: sending message to own frame not through network
				} else {
					app.client.sendMessage(field.getText());
					updateChat("Client: " + field.getText());
					field.setText(null);
				}
			}
		}

	}

	public static void main(String[] args) {
		new Display();
	}
}
