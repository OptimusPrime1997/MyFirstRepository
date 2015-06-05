package copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class MyFile {
	String fileName;
	ArrayList<String> str = new ArrayList<String>();

	public MyFile(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<String> readFromFile() {

		ArrayList<String> list = new ArrayList<String>();

		try {
			File f = new File("CurriculumSchedule.txt");
			BufferedReader br1 = new BufferedReader(new FileReader(f));
			String line;

			while ((line = br1.readLine()) != null) {
				list.add(line);
			}
			br1.close();

			// if(f.exists()){
			// InputStream is =
			// this.getClass().getResourceAsStream("file/CurriculumSchedule.txt");
			// System.out.println("aaaa"+f.getPath());
			// //BufferedReader br1=new BufferedReader(new FileReader(f));
			// BufferedReader br1=new BufferedReader(new InputStreamReader(is));
			// String line;
			//
			// while((line=br1.readLine())!=null){
			// list.add(line);
			// }
			// br1.close();
			// }else{
			// boolean createOK = false;
			// if (!f.getParentFile().exists())
			// f.getParentFile().mkdirs();
			// if (!f.exists())
			// createOK=f.createNewFile();
			// if(createOK){
			// BufferedReader br1=new BufferedReader(new FileReader(f));
			// String line;
			//
			// while((line=br1.readLine())!=null){
			// list.add(line);
			// }
			// br1.close();
			// }
			// }

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return list;
	}

	public void AppendToFile(String output) {

		try {
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(output);
			// System.out.println(output);
			writer.close();
			System.out.println("已添加到文件中\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void removeFromFile(Course c) {
		String ce = c.toString();
		try {
			RandomAccessFile raf = new RandomAccessFile(new File(fileName),
					"rw");
			String tempLine = null;
			while ((tempLine = raf.readLine()) != null) {
				if (tempLine != ce) {
					str.add(tempLine);
				}
			}
			raf.setLength(0);

			for (int i = 0; i < str.size(); i++) {
				raf.writeBytes(str.get(i) + "\n");
			}

			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
