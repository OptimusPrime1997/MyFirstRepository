
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;



public class CourseSchedule {
	
	ArrayList<Course> courseList = new ArrayList<Course>();
	MyFile file;

	
	public CourseSchedule(String fileName){

		file = new MyFile(fileName);
		//System.out.println("File : "+file);
		ArrayList<String> list = file.readFromFile();
		
		for(String s:list)
			courseList.add(new Course(s));
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule cs = new CourseSchedule("CurriculumSchedule.txt");
		cs.run();
		
	}
	public void run(){
		MyConsole console = new MyConsole();
		
		while(true){
			
			String input = console.inputFromConsole();
			
			Command command = new Command(input);
			
			int cmd = command.getCmd();
			Course course = command.getCourse();
			System.out.println("running..."+course);
			
			process(cmd, course);
		}
	}
	public void process(int cmd, Course course){
		 switch(cmd){
		 case 0: add(course);break;
		 case 1: remove(course);break;
		 case 2: update(course);break;
		 case 3: find(course);break;
		 case 4: show(course);break;
		 default:break;
	 }
	}
	
	public void add(Course c){
		boolean isOK = false;
		
		//System.out.println(c);
		isOK = isOKtoAdd(c);
		if(isOK){
			System.out.println("Addinging... "+c);
			courseList.add(c);
			file.AppendToFile(c.toString()+"\n");
			
		}else{
			System.out.println("该时间已经有课了！");
		}
		
		
	}
	public boolean isOKtoAdd(Course c){
		
		boolean isOk= true;
		
		
		
		for(Course course:courseList){
			//System.out.println(course.toString()+"\n");
			
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
			//System.out.println(s1+"-----"+s2+"\n");
			if(s1.equals(s2)&&course.time.equals(c.time)){
				//System.out.println(course.time+"-----"+c.time+"\n");
				isOk = false;
				break;
			}
		}
		
		return isOk;
	}
	public void remove(Course c){
		//Remove
		boolean isOk=true;
		isOk=isOkToRemove(c);
		if(isOk){
			
			courseList.remove(c);
			file.removeFromFile(c);
			System.out.println("Removinging..."+c);
			
			System.out.println("已从文件删除！");
			
		}else{
			System.out.println("该课程不在课表中！");
		}
	}
	
	/**
	 * @param c
	 * @return
	 */
	/**
	 * @param c
	 * @return
	 */
	public boolean isOkToRemove(Course c){
		boolean isOk=true;
	
		for(Course course:courseList){
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
			//System.out.println(s1+"-----"+s2+"\n");
			if(s1.equals(s2)&&course.time.equals(c.time)
					&&course.name.equals(c.time)
					&&course.location.equals(c.location)){
				isOk = false;
				break;
			}
		}
		
		return isOk;
	}
	
	
	public void update(Course c){
		boolean isOk=false;
		
		isOk=isOkToUpdate(c);
		//System.out.println("isOkToUpdate--"+isOk+"\n");
		if(isOk){
			
			add(c);
			System.out.println("Updating..."+c);
		}
	}
public boolean isOkToUpdate(Course c){
		
		boolean isOk= false;
		
		
		
		for(Course course:courseList){
			//System.out.println(course.toString()+"\n");
			//System.out.println("+++++course----"+course.toString()+"\n");
			
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
			//System.out.println(s1+"-----"+s2+"\n");
			if(s1.equals(s2)&&course.time.equals(c.time)){
				//System.out.println(course.time+"-----"+c.time+"\n");
				//System.out.println("course----"+course.toString()+"\n");
				
				if(course.name.equals(c.name)
					&&course.location.equals(c.location)){
						isOk = false;
						System.out.println("需要更新的课程已存在！\n");
						
				}else{
					//System.out.println("course----"+course.toString()+"\n");
					
					isOk=true;
					remove(course);
				}	
				break;
			}
		}
		
		return isOk;
	}
	
	
	public void find(Course c){
	
		
		System.out.println("finding..."+c);
		
		for(Course course:courseList){
			//System.out.println(course.toString()+"\n");
			//System.out.println("+++++course----"+course+"\n");
			
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
			//System.out.println(s1+"-----"+s2+"\n");
			if(s1.equals(s2)&&course.time.equals(c.time)){
				System.out.println("\n该时间的课程： "+course.name+"；"+course.location+"\n");
				
			}
		}
		
	}
	
	public void show(Course c){
		Collections.sort(courseList);
		
	
		for(Course course:courseList){
			//System.out.println(course.toString()+"\n");
			System.out.println("course:"+course+"\n");
		}
		
		
		try{
			FileWriter writer=new FileWriter(file.fileName,false);
			for(int i=0;i<courseList.size();i++){
				writer.write(courseList.get(i).toString()+"\n");
			}
			
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
