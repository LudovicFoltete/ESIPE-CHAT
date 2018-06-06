package messagerie.serveur;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Window extends JFrame {

  private static final long serialVersionUID = 1L;
  private JTextArea text = new JTextArea();

  public Window() {
    this.setTitle("Server");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setContentPane(text);
    this.setLocationRelativeTo(null);
    this.text.setEditable(false);
    this.setSize(400, 400);
    this.setVisible(true);
  }
  
  public void addText(String s) {
    text.setText(text.getText() + "\r\n" + s);
  }
  
}
