import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CourseTest {

	@Test
	public void test() {

		Course course = new Course("星期五；三四节；软工  ；仙2-405");
		assertEquals(course.time, "三四节");
		assertEquals(course.name, "软工 ");
		assertEquals(course.location, "仙2-405");
	}

}
