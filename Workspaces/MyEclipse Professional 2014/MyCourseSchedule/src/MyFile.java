import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyFile {
	String fileName;

	public MyFile(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<String> readFromFile() {
		ArrayList<String> list = new ArrayList<String>();

		try {
			File file = new File("CurriculumSchedule.txt");
			BufferedReader br1 = new BufferedReader(new FileReader(file));
			String line;

			while ((line = br1.readLine()) != null) {
				list.add(line);
			}
			br1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void AppendToFile(String output) {
		try {
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(output);
			writer.close();
			System.out.println("已添加到文件中！\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
