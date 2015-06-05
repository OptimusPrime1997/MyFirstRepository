import java.util.ArrayList;

public class CourseSchedule {
	ArrayList<Course> courseList = new ArrayList<Course>();
	MyFile file;

	public CourseSchedule(String fileName) {
		file = new MyFile(fileName);
		ArrayList<String> list = file.readFromFile();

		for (String s : list)
			courseList.add(new Course(s));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule cs = new CourseSchedule("CurriculumSchedule。txt");
		cs.run();
	}

	public void run() {
		MyConsole console = new MyConsole();

		while (true) {
			String input = console.inputFromConsole();
			Command command = new Command(input);
			int cmd = command.getCmd();
			Course course = command.getCourse();

			System.out.println("running: " + course);
			process(cmd, course);
		}
	}

	public void process(int cmd, Course course) {
		switch (cmd) {
		case 0:
			add(course);
			break;
		case 1:
			remove();
			break;
		case 2:
			update();
			break;
		case 3:
			find();
			break;
		case 4:
			show();
			break;
		}
	}

	public void add(Course c) {
		boolean isOk = false;

		System.out.println(c);
		isOk = isOkToAdd(c);
		if (isOk) {
			courseList.add(c);
		}
		file.AppendToFile(c.toString() + "\n");
	}

	public boolean isOkToAdd(Course c) {
		boolean isOk = true;

		System.out.println(c);
		for (Course course : courseList) {
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
			if (s1.equals(s2) && course.time.equals(c.time)) {
				isOk = false;
				break;
			}
		}
		return isOk;

	}

	public void remove() {

	}

	public void update() {

	}

	public void find() {

	}

	public void show() {

	}

}
