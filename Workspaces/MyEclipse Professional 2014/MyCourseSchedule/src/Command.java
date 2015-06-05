
public class Command {
	int cmd=-1;
	Course course;
	String[] split;
	public Command(String input){
		String command;
		split=input.split(" ");
		command=split[0];
		
	    String[] cmds={"Add","Remove","Update","Find","Show"};
		for(int i=0;i<cmds.length;i++){
			if(command.equals(cmds[i])==true){
				cmd=i;
				break;
			}
		}
		System.out.println(command+": "+split[1]);
		course=new Course(split[1]);
	}
	
	public int getCmd(){
		return cmd;
	}
	public Course getCourse(){
		return course;
	}
}
