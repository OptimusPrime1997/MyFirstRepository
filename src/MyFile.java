import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;



public class MyFile {
	String fileName;

	
	public MyFile(String fileName){
		this.fileName = fileName;
	}
	
	public ArrayList<String> readFromFile(){

		ArrayList<String> list = new ArrayList<String>();
		
		try{
			File f = new File("CurriculumSchedule.txt");
			BufferedReader br1=new BufferedReader(new FileReader(f));
		    String line;
		
		    while((line=br1.readLine())!=null){
			    list.add(line);
		    }
		    br1.close();
		    
//			if(f.exists()){
//			    InputStream is = this.getClass().getResourceAsStream("file/CurriculumSchedule.txt");
//			    System.out.println("aaaa"+f.getPath());
//			    //BufferedReader br1=new BufferedReader(new FileReader(f));
//			    BufferedReader br1=new BufferedReader(new InputStreamReader(is));
//			    String line;
//			
//			    while((line=br1.readLine())!=null){
//				    list.add(line);
//			    }
//			    br1.close();
//			}else{
//				boolean createOK = false;
//				if (!f.getParentFile().exists())
//				    f.getParentFile().mkdirs();
//				if (!f.exists())
//					createOK=f.createNewFile();
//				if(createOK){
//					BufferedReader br1=new BufferedReader(new FileReader(f));
//				    String line;
//				
//				    while((line=br1.readLine())!=null){
//					    list.add(line);
//				    }
//				    br1.close();
//				}
//			}
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		return list;
	}
	public void AppendToFile(String output){

		try{			
			FileWriter writer = new FileWriter(fileName,true);
			writer.write(output);
//			System.out.println(output);
			writer.close();
			System.out.println("已添加到文件中\n");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public void removeFromFile(Course c){
		String ce=c.toString();
		ArrayList<String> str=new ArrayList<String>();
		
		
		try{
			BufferedReader br=new BufferedReader(
			 new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
			String tempLine=null;
			while((tempLine=br.readLine())!=null){
				//System.out.println("tempLine:"+tempLine);
				if(!(tempLine.equals(ce))){
					//System.out.println("tempLine1:"+tempLine);
					str.add(tempLine);
				}
			}
			br.close();
			

			FileWriter writer=new FileWriter(fileName,false);
			
			for(int i=0;i<str.size();i++){
				writer.write(str.get(i)+"\n");
			}
			
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
