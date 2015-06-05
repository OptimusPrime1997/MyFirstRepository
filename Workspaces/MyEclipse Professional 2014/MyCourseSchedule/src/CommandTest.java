import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommandTest {

	@Test
	public void test() {
		Command cd = new Command("Add 星期四；一二节；软工；仙2-403");
		assertEquals(cd.split[1], "星期四；一二节；软工；仙2-403");
	}

}
