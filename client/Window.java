package messagerie.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private JTextField input = new JTextField("Write a message to your friends");
	private JLabel bottom = new JLabel("Your message :");
	private JTextArea center = new JTextArea();
	private String user;
	private PrintWriter out;
	
	public Window(String nickname, BufferedReader in, PrintWriter out) {
	  user = "<"+nickname+"> : ";
	  this.out = out;
	  
		this.setTitle("Welcome to the ESIPE TCHAT");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		
		input.setFont(new Font("Arial", Font.BOLD, 20));
		input.setPreferredSize(new Dimension(350, 60));
		input.setForeground(Color.BLUE);
		input.addKeyListener(this);
		
		center.setFont(new Font("Arial", Font.BOLD, 20));
		center.setEditable(false);
		JScrollPane textArea = new JScrollPane(center);
		container.add(textArea);
		
		JPanel lowPanel = new JPanel();
		bottom.setFont(new Font("Arial", Font.BOLD, 18));
		lowPanel.add(bottom);
		lowPanel.add(input);
		container.add(lowPanel, BorderLayout.SOUTH);
		
		this.setResizable(false);
		this.setContentPane(container);
		this.setVisible(true);
		
		Reception r = new Reception(in, center);
		r.start();
	}
	

	public final void keyPressed(final KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!input.getText().isEmpty()) {
				center.setText(center.getText() + user + input.getText() + "\r\n");
				Backup.save(user + input.getText() + "\r\n");
				out.println(user + input.getText());
				out.flush();
				input.setText("");
			}
		}
	}

	public void keyReleased(final KeyEvent arg0) {}

	public void keyTyped(final KeyEvent arg0) {}

}
