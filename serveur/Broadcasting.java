package messagerie.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Broadcasting extends Thread {

  private BufferedReader in;
  private PrintWriter out;
  private String nickname;
  private Window window;
  
  public Broadcasting(User u1, User u2) {
    try {
      in = new BufferedReader(new InputStreamReader(u1.getSocket().getInputStream()));
      out = new PrintWriter(u2.getSocket().getOutputStream());
      nickname = u1.getNickname();
      window = u1.getWindow();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void run() {
    try {
      while(true) {
        String message = in.readLine();
        out.println(message);
        out.flush();
      }
    } catch(IOException e) {
      window.addText(nickname + " is deconnected himself !");
    }
  }
}
