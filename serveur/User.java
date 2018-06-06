package messagerie.serveur;

import java.net.Socket;

public class User {

  private Socket socket;
  private String nickname;
  private Window window;
  
  public User(Socket s, String n, Window w) {
    socket = s;
    nickname = n;
    window = w;
  }

  public Socket getSocket() {
    return socket;
  }

  public String getNickname() {
    return nickname;
  }

  public Window getWindow() {
    return window;
  }
}
