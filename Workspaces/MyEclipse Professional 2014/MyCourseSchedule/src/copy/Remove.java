package copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Remove {

	public static void remove(File file, Course c) {

		RandomAccessFile readFile = null;

		try {
			readFile = new RandomAccessFile(file, "r");
			readFile.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RandomAccessFile writeFile = null;

		try {
			writeFile = new RandomAccessFile(file, "rw");
			String tempLine = null;
			while ((tempLine = readFile.readLine()) != null) {
				if (tempLine == c.toString()) {
					continue;
				}
				writeFile.writeBytes(tempLine + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			readFile.close();
			writeFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}