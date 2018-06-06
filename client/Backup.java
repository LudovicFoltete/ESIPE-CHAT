package messagerie.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Backup {
	
	private static Path PATH = Paths.get("TCHAT.txt");
	
	public static void save(String text) {
		try(BufferedWriter writer = Files.newBufferedWriter(PATH, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
			writer.write(text);
		} catch(IOException e) { e.printStackTrace(); }
	}
}

