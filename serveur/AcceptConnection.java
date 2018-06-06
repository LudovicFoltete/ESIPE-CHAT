package messagerie.serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptConnection extends Thread {

  private ServerSocket serverSocket;
  private Socket socket;
  private Window window;
  
  
  public AcceptConnection(ServerSocket s, Window w) {
    serverSocket = s;
    window = w;
  }
  
  public void run() {
    try {
      while (true) {
        socket = serverSocket.accept();
        window.addText("New connection : Authentication in progress");
        Authentication a = new Authentication(socket, window);
        a.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
