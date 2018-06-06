package messagerie.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {

  public static Socket socket;
  
  public static void main(String[] args) {
    try {
      socket = new Socket(InetAddress.getLocalHost(), 9103);
      
      Connection c = new Connection(socket);
      c.start();
      
    } catch (UnknownHostException e) {
      String error = "Cannot connect to "+socket.getLocalAddress();
      JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException e) {
      String error = "No server "+socket.getLocalPort();
      JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

}
