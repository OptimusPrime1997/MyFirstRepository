package copy;

import java.util.ArrayList;

public class CourseSchedule {

	Remove rm = new Remove();

	ArrayList<Course> courseList = new ArrayList<Course>();
	MyFile file;

	public CourseSchedule(String fileName) {

		file = new MyFile(fileName);
		// System.out.println("File"+fileName);
		ArrayList<String> list = file.readFromFile();

		for (String s : list)
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

	public void run() {
		MyConsole console = new MyConsole();

		while (true) {

			String input = console.inputFromConsole();
			Command command = new Command(input);

			int cmd = command.getCmd();
			Course course = command.getCourse();
			System.out.println("dealing：" + course);

			process(cmd, course);
		}
	}

	public void process(int cmd, Course course) {
		switch (cmd) {
		case 0:
			add(course);
			break;
		case 1:
			remove(course);
			break;
		case 2:
			update(course);
			break;
		case 3:
			find(course);
			break;
		case 4:
			show(course);
			break;
		}
	}

	public void add(Course c) {
		boolean isOK = false;

		System.out.println("adding:" + c);

		isOK = isOKToAdd(c);
		if (isOK) {
			courseList.add(c);
			file.AppendToFile(c.toString() + "\n");
		}

	}

	public boolean isOKToAdd(Course c) {

		boolean isOK = true;

		for (Course course : courseList) {
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
			// System.out.println(s1+"-----"+s2+"\n");
			if (s1.equals(s2) && course.time.equals(c.time)) {
				isOK = false;
				System.out.println("该时间已经有课了！");
				break;
			}
		}

		return isOK;
	}

	public void remove(Course c) {
		// Remove

		boolean isOk = true;
		isOk = isOkToRemove(c);
		if (isOk) {

			courseList.remove(c);
			System.out.println("Removing:" + c);

			Remove rm = new Remove();

			file.removeFromFile(c);

			System.out.println("该课程已从课表删除！");

		} else {
			System.out.println("该课程不存在！");
		}

	}

	public boolean isOkToRemove(Course c) {
		boolean isOk = false;

		for (Course course : courseList) {
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();

			if (s1.equals(s2) && course.time.equals(c.time)
					&& course.name.equals(c.name)
					&& course.location.equals(c.location)) {
				isOk = true;
				break;
			}
		}

		return isOk;
	}

	public void update(Course c) {
		// Update
		System.out.println("Update...");
	}

	public void find(Course c) {
		// Find
		System.out.println("Finding...");
	}

	public void show(Course c) {
		// Show
		System.out.println("Showing...");
	}

}
