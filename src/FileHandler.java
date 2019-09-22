import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class FileHandler {

	public static ArrayList<String> getFile(String address) throws IOException, FileNotFoundException {
		File file = new File(address);
		Scanner scanner = new Scanner(file);
		ArrayList<String> myFile = new ArrayList<String>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			myFile.add(line);
		}
		return myFile;
	}
	
	public static BufferedImage getImageFile(String name){
		try {
			return ImageIO.read(new File("Files"+name+".png"));
		} catch (IOException exception) {}
		return null;
	}
}
