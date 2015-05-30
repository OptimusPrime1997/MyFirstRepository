/**
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;



public class ALUTest {

	ALU alu = new ALU();

	// extra
	@Test
	public void testRounding() {
		assertEquals("0101000010001101",
				alu.rounding("01010000100011001", 9, 6, 1));
		assertEquals("00111111", alu.rounding("001111101", 4, 3, 1));
		assertEquals("00110000", alu.rounding("001011111", 4, 3, 1));
		assertEquals("01110000", alu.rounding("011011111", 4, 3, 1));
	}

	@Test
	public void testCalculation() {
		 assertEquals("-2", alu.calculation("5+(-7)="));
		 assertEquals("12", alu.calculation("5-(-7)="));
		 assertEquals("16", alu.calculation("4*4="));
		 assertEquals("2", alu.calculation("9/4="));
		 assertEquals("1.4375", alu.calculation("0.8125+0.625="));
		 assertEquals("-0.1875", alu.calculation("0.625-0.8125="));
		assertEquals("0.1875", alu.calculation("0.8125-0.625="));
		assertEquals("0.0625", alu.calculation("0.5+(-0.4375)="));
		assertEquals("0.21875", alu.calculation("0.5*0.4375="));
		assertEquals("66", alu.calculation("0.75-(-65.25)="));
		assertEquals("-48.9375", alu.calculation("0.75*(-65.25)="));
		assertEquals("-0.01149425283074379", alu.calculation("0.75/(-65.25)="));
		
	
	}

	// 2
	@Test
	public void testIntegerRepresentation() {
		assertEquals("110000", alu.integerRepresentation("-16", 6));
		assertEquals("1111111111111111", alu.integerRepresentation("-1", 16));
		assertEquals("01", alu.integerRepresentation("1", 2));
	}

	// 3
	@Test
	public void testFloatRepresentation() {
		assertEquals("00111111100000000000000000000000",
				alu.floatRepresentation("1", 23, 8));
		assertEquals("00111111000000000000000000000000",
				alu.floatRepresentation("0.5", 23, 8));
		assertEquals("10111111000000000000000000000000",
				alu.floatRepresentation("-0.5", 23, 8));
		assertEquals("10111110111000000000000000000000",
				alu.floatRepresentation("-0.4375", 23, 8));
		assertEquals("1100001110111101",
				alu.floatRepresentation("-7.4765625", 9, 6));
		assertEquals("0101000010001100", alu.floatRepresentation("652", 9, 6));
		assertEquals("00000100000000",
				alu.floatRepresentation("0.0078125", 9, 4));
		assertEquals("10000100000000",
				alu.floatRepresentation("-0.0078125", 9, 4));
		assertEquals("1100001110111101",
				alu.floatRepresentation("-7.4765625", 9, 6));
		assertEquals("1100001110111101", alu.floatRepresentation("-7.48", 9, 6));
		assertEquals("0101000010001101",
				alu.floatRepresentation("652.51", 9, 6));

	}

	// 4
	@Test
	public void testIeee754() {
		assertEquals("00111111100000000000000000000000", alu.ieee754("1", 32));
		assertEquals(
				"0011111111110000000000000000000000000000000000000000000000000000",
				alu.ieee754("1", 64));
	}

	// 5
	@Test
	public void testIntegerTrueValue() {
		assertEquals("-1", alu.integerTrueValue("11111"));
		assertEquals("20", alu.integerTrueValue("010100"));
	}

	// 6
	@Test
	public void testFloatTrueValue() {
		assertEquals("1",
				alu.floatTrueValue("00111111100000000000000000000000", 23, 8));
		assertEquals(
				"1",
				alu.floatTrueValue(
						"0011111111110000000000000000000000000000000000000000000000000000",
						52, 11));
		assertEquals("0.5",
				alu.floatTrueValue("00111111000000000000000000000000", 23, 8));
		assertEquals("-0.5",
				alu.floatTrueValue("10111111000000000000000000000000", 23, 8));
		assertEquals("-0.4375",
				alu.floatTrueValue("10111110111000000000000000000000", 23, 8));

		assertEquals("-7.4765625", alu.floatTrueValue("1100001110111101", 9, 6));
		assertEquals("652", alu.floatTrueValue("0101000010001100", 9, 6));
		assertEquals("+Inf", alu.floatTrueValue("01111000000000", 9, 4));
		assertEquals("-0.0078125", alu.floatTrueValue("10000100000000", 9, 4));
		assertEquals("0.0078125", alu.floatTrueValue("00000100000000", 9, 4));
		assertEquals("-7.4765625", alu.floatTrueValue("1100001110111101", 9, 6));
		assertEquals("-7.4765625", alu.floatTrueValue("1100001110111101", 9, 6));

	}

	// 8
	@Test
	public void testLeftShift() {
		assertEquals("0101111100000", alu.leftShift("1010101011111", 5));
		assertEquals("0100", alu.leftShift("0101", 2));
	}

	// 9
	@Test
	public void testRightAriShift() {
		assertEquals("1111110101010", alu.rightAriShift("1010101011111", 5));
		assertEquals("00011", alu.rightAriShift("01101", 2));
	}

	// 9
	@Test
	public void testRightLogShift() {
		assertEquals("0000010101010", alu.rightLogShift("1010101011111", 5));
		assertEquals("00011", alu.rightLogShift("01101", 2));
	}

	// 7
	@Test
	public void testNegation() {
		assertEquals("11110", alu.negation("00001"));
		assertEquals("0111", alu.negation("1000"));
	}

	
	// 12

	@Test
	public void testFullAdder() {
		assertEquals("11", alu.fullAdder('1', '1', '1'));
	}

	@Test
	public void testIntegerAddition() {
		assertEquals("1111111100",
				alu.integerAddition("1111111", "1111111", '0', 9));
		assertEquals("10011", alu.integerAddition("0111", "0010", '0', 4));
	}

	
	// 13
	@Test
	public void testCLAAdder() {
		assertEquals("100000000", alu.claAdder("00101001", "01010111", '0'));
		assertEquals("000000100", alu.claAdder("00000001", "00000001", '0'));
		assertEquals("111111111", alu.claAdder("11111111", "11111111", '1'));
		assertEquals("111111101", alu.claAdder("11111111", "11111111", '0'));
	}

	// 14
	@Test
	public void testIntegerSubstraction() {
		assertEquals("00100", alu.integerSubtraction("0101", "0011", 4));
		assertEquals("10101", alu.integerSubtraction("0111", "1101", 4));
	}

	// 15
	@Test
	public void testIntegerMultiplication() {
		assertEquals("00001111", alu.integerMultiplication("0101", "0011", 4));
		assertEquals("00101010", alu.integerMultiplication("1001", "1010", 4));
		assertEquals("11101011", alu.integerMultiplication("0111", "1101", 4));
	}

	// 16
	@Test
	public void testIntegerDivision() {
		assertEquals("11101111", alu.intergerDivision("1001", "0011", 4));
		assertEquals("00100001", alu.intergerDivision("0111", "0011", 4));
		assertEquals("11100001", alu.intergerDivision("0111", "1101", 4));

	}

	// 17
	@Test
	public void testFloatAddition() {
		assertEquals("001111111000000000000000000000000", alu.floatAddition(
				"00111111100000000000000000000000",
				"00000000000000000000000000000000", 23, 8, 4));
		assertEquals("001111111000000000000000000000000", alu.floatAddition(
				"00000000000000000000000000000000",
				"00111111100000000000000000000000", 23, 8, 4));
		assertEquals("001111011000000000000000000000000", alu.floatAddition(
				"00111111000000000000000000000000",
				"10111110111000000000000000000000", 23, 8, 0));
		assertEquals("001111111011100000000000000000000", alu.floatAddition(
				"00111111010100000000000000000000",
				"00111111001000000000000000000000", 23, 8, 0));
		assertEquals("001111100100000000000000000000000", alu.floatAddition(
				"00111111010100000000000000000000",
				"10111111001000000000000000000000", 23, 8, 0));
	}

	// 18
	@Test
	public void testFloatSubtraction() {
		assertEquals("001111111000000000000000000000000", alu.floatSubtraction(
				"00111111100000000000000000000000",
				"10000000000000000000000000000000", 23, 8, 4));
		assertEquals("001111111000000000000000000000000", alu.floatSubtraction(
				"00000000000000000000000000000000",
				"10111111100000000000000000000000", 23, 8, 4));
		assertEquals("001111011000000000000000000000000", alu.floatSubtraction(
				"00111111000000000000000000000000",
				"00111110111000000000000000000000", 23, 8, 0));
		assertEquals("001111111011100000000000000000000", alu.floatSubtraction(
				"00111111010100000000000000000000",
				"10111111001000000000000000000000", 23, 8, 0));
		assertEquals("001111100100000000000000000000000", alu.floatSubtraction(
				"00111111010100000000000000000000",
				"00111111001000000000000000000000", 23, 8, 0));
	}

	// 19
	@Test
	public void testFloatMultiplication() {
		assertEquals("10111110011000000000000000000000",
				alu.floatMultiplication("00111111000000000000000000000000",
						"10111110111000000000000000000000", 23, 8));
		assertEquals("11000010010000111100000000000000",
				alu.floatMultiplication("00111111010000000000000000000000",
						"11000010100000101000000000000000", 23, 8));
		// assertEquals("001111011000000000000000000000000",
		// alu.floatMultiplication("00111111000000000000000000000000",
		// "00111110111000000000000000000000",23, 8));
		// assertEquals("001111111011100000000000000000000",
		// alu.floatMultiplication("00111111010100000000000000000000",
		// "10111111001000000000000000000000",23, 8));
	}

	// 20
	@Test
	public void testFloatDivision() {
		assertEquals("00111111011000000000000000000000", alu.floatDivision(
				"00111110111000000000000000000000",
				"00111111000000000000000000000000", 23, 8));
		assertEquals("10111100001111000101001001100100", alu.floatDivision(
				"00111111010000000000000000000000",
				"11000010100000101000000000000000", 23, 8));
	}
}
