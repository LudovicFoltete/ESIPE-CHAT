package messagerie.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Authentication extends JFrame  {
  
  private static final long serialVersionUID = 1L;
  private JTextField nickname = new JTextField();
  private JTextField password = new JPasswordField();
  private JPanel container = new JPanel();
  
  public Authentication(Connection c) {
    this.setTitle("Authentication");
    this.setSize(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    container.setBackground(Color.WHITE);
    Font font = new Font("Arial", Font.BOLD, 20);
    
    Box b1 = Box.createHorizontalBox();
    nickname.setFont(font);
    nickname.setPreferredSize(new Dimension(240, 60));
    nickname.addKeyListener(c);
    JLabel l1 = new JLabel("Nickname :");
    l1.setFont(font);
    b1.add(l1);
    b1.add(nickname);
    
    Box b2 = Box.createHorizontalBox();
    password.setFont(font);
    password.setPreferredSize(new Dimension(240, 60));
    password.addKeyListener(c);
    JLabel l2 = new JLabel("Password :");
    l2.setFont(font);
    b2.add(l2);
    b2.add(password);
    
    Box b3 = Box.createHorizontalBox();
    JButton button = new JButton("Sign in");
    button.setPreferredSize(new Dimension (60, 60));
    button.addMouseListener(c);
    b3.add(button);
    
    Box space1 = Box.createHorizontalBox();
    JPanel pane1 = new JPanel();
    pane1.setPreferredSize(new Dimension(240, 60));
    pane1.setBackground(Color.WHITE);
    space1.add(pane1);
    Box space2 = Box.createHorizontalBox();
    JPanel pane2 = new JPanel();
    pane1.setPreferredSize(new Dimension(240, 60));
    pane2.setBackground(Color.WHITE);
    space2.add(pane2);
    
    Box b4 = Box.createVerticalBox();
    b4.add(b1);
    b4.add(space1);
    b4.add(b2);
    b4.add(space2);
    b4.add(b3);
    container.add(b4);
    
    this.setResizable(false);
    this.setContentPane(container);
    this.setVisible(true);
  }

  public JTextField getNickname() {
    return nickname;
  }

  public JTextField getPassword() {
    return password;
  }
}
