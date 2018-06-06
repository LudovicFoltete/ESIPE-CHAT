package messagerie.serveur;

import java.util.ArrayList;

public class Chat {

  private static ArrayList<User> LIST_USERS = new ArrayList<User>();
  
  public static void addUser(User u) {
    LIST_USERS.add(u);
    if(LIST_USERS.size() > 1) {
      Broadcasting b1 = new Broadcasting(LIST_USERS.get(0), LIST_USERS.get(1));
      Broadcasting b2 = new Broadcasting(LIST_USERS.get(1), LIST_USERS.get(0));
      b1.start();
      b2.start();
    }
  }
}
