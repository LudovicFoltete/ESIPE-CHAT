package messagerie.client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Connection extends Thread implements KeyListener, MouseListener{

  private Socket socket;
  private JTextField nickname;
  private JTextField password;
  private BufferedReader in;
  private PrintWriter out;
  private Authentication a = new Authentication(this);
  
  public Connection(Socket socket) {
    this.socket = socket;
  }
  
  public void run() {
    nickname = a.getNickname();
    password = a.getPassword();
    
    try {
      out = new PrintWriter(socket.getOutputStream());
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      
    } catch (IOException e) {
      String error = "The server don't reply any more";
      JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
      a.dispose();
    }
  }
  
  public void mouseClicked(MouseEvent e) {
    try {
      if(!nickname.getText().isEmpty() && !password.getText().isEmpty()) {
        out.println(nickname.getText());
        out.println(password.getText());
        out.flush();
        
        if(in.readLine().equals("connected")) {
          a.dispose();
          Window w = new Window(nickname.getText(), in, out);
        }
        else 
          JOptionPane.showMessageDialog(null, "Wrong password !", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }catch (IOException arg) {
      String error = "The server don't reply any more";
      JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
      a.dispose();
    }
  }

  public void mouseEntered(MouseEvent arg0) {}

  public void mouseExited(MouseEvent arg0) {}

  public void mousePressed(MouseEvent arg0) {}

  public void mouseReleased(MouseEvent arg0) {}

  public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
      if(!nickname.getText().isEmpty() && !password.getText().isEmpty()) {
        try {
          if(!nickname.getText().isEmpty() && !password.getText().isEmpty()) {
            out.println(nickname.getText());
            out.println(password.getText());
            out.flush();
            
            if(in.readLine().equals("connected")) {
              a.dispose();
              Window w = new Window(nickname.getText(), in, out);
            }
            else 
              JOptionPane.showMessageDialog(null, "Wrong password !", "Error", JOptionPane.ERROR_MESSAGE);
          }
        }catch (IOException arg) {
          String error = "The server don't reply any more";
          JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
          a.dispose();
        }
      }
    }
  }

  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}
}
