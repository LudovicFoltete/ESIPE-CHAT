package messagerie.client;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class Reception extends Thread {

  private BufferedReader in;
  private JTextArea text;
  
  public Reception(BufferedReader in, JTextArea text) {
    this.in = in;
    this.text = text;
  }
  
  public void run() {
    while (true) {
      try {
        String message = in.readLine();
        text.setText(text.getText() + message + "\r\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
