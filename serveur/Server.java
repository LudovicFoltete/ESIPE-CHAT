package messagerie.serveur;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
  
  public static void main(String[] args) {
    
    try {
      ServerSocket serversocket = new ServerSocket(9103);
      
      Window w = new Window();
      
      Thread t = new AcceptConnection(serversocket, w);
      t.start();
      
      w.addText("Server ready : port 9103");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
