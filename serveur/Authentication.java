package messagerie.serveur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Authentication extends Thread {
  
  private Socket socket;
  private Window window;

  public Authentication(Socket s, Window w) {
    socket = s;
    window = w;
  }
  
  public void run() {
    try {
      PrintWriter out = new PrintWriter(socket.getOutputStream());
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      
      String nickname = in.readLine();
      String password = in.readLine();
      
      while(!check(nickname, password)) {
        out.println("Error in the password");
        out.flush();
        window.addText("Error in authentication");
        nickname = in.readLine();
        password = in.readLine();
      }
      
      out.println("connected");
      out.flush();
      window.addText(nickname + " just signed in !");
      
      User user = new User(socket, nickname, window);
      Chat.addUser(user);
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private boolean check(String nickname, String password) {
    try {
      Scanner sc = new Scanner(new File("nicknames.txt"));
      
      while(sc.hasNext()) {
        if(sc.nextLine().equals(nickname + " " + password)) {
          sc.close();
          return true;
        }
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.err.println("Nickname's file not found");
    }
    return false;
  }
}
