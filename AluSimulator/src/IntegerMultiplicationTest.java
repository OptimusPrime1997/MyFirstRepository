import static org.junit.Assert.*;

import org.junit.Test;


public class IntegerMultiplicationTest {
	IntegerMultiplicationQuick imq=new IntegerMultiplicationQuick();
	@Test
	public void testIntegerMultiplicationQuick() {
		assertEquals("00001111", imq.integerMultiplicationQuick("0101", "0011", 4));
		assertEquals("00101010", imq.integerMultiplicationQuick("1001", "1010", 4));
		assertEquals("11101011", imq.integerMultiplicationQuick("0111", "1101", 4));
		assertEquals("00011001", imq.integerMultiplicationQuick("0101", "0101", 4));
		assertEquals("00110001", imq.integerMultiplicationQuick("0111", "0111", 4));
		assertEquals("00000001", imq.integerMultiplicationQuick("1111", "1111", 4));
	}



}
