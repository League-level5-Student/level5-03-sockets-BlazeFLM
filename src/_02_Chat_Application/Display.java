package _02_Chat_Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display implements ActionListener {

	JFrame frame;
	JPanel panel;
	JTextField field;
	JButton button;
	JLabel displayText;

	public Display() {
		frame = new JFrame("Simple Chat Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();

		field = new JTextField(20);

		button = new JButton("Send");
		button.addActionListener(this);
		displayText = new JLabel();

		panel.add(field);
		panel.add(button);
		panel.add(displayText);

		frame.add(panel);

		frame.setVisible(true);

		frame.pack();
	}

	public static void main(String[] args) {
		new Display();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button)) {
			//send field.getText() somewhere
		}
		
	}
}
