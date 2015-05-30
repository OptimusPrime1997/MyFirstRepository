import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import sun.security.util.Length;

import com.sun.jndi.toolkit.ctx.StringHeadTail;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

//罗金宏  学号：141250085
public class ALU {
	public enum Operation {
		ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
	};

	public enum Type {
		INTEGER, FLOAT, DECIMAL
	};

	// 1
	public String calculation(String formula) {
		assert formula != null;
		String result = "";
		String[] operand = new String[2];
		String[] interval = new String[2];
		String oper1="";
		String oper2="";
		String temp="";
		String formula1 = "";
		String bin1 = "";
		String bin2 = "";
		String eS1 = "";
		String eS2 = "";
		String sigS1 = "";
		String sigS2 = "";
		String sigT = "";
		String sigS2N = "";
		String sigS = "";
		String sigST = "";
		String rS = "";
		String sig = "";
		String all = "";

		String temp1 = "";
		int sigInt1 = 0;
		int sigInt2 = 0;
		int eInt1 = 0;
		int eInt2 = 0;
		int eInt = 0;
		int standard = 0;
		if (!formula.contains("-")
				|| (formula.contains("-") && equals(!formula.contains("\\(")))) {
			operand = formula.split("\\+|\\*|-|\\/|=");
		} else if (formula.contains("\\(") && formula.contains("\\(")) {
			if (formula.indexOf(0) == '(') {
				operand[0] = formula.substring(formula.indexOf("\\(") + 1,
						formula.indexOf("\\)"));
				interval = formula.split(operand[0]
						+ "|\\(|\\)|\\+|-|\\*|\\/|=");
				operand[1] = interval[0];
			} else {
				operand[1] = formula.substring(formula.indexOf("\\(") + 1,
						formula.indexOf("\\)"));
				interval = formula.split(operand[1]
						+ "|\\(|\\)|\\+|-|\\*|\\/|=");
				operand[0] = interval[0];
			}

		}
		if ((!operand[0].contains(".")) && (!operand[1].contains("."))) {
			oper1=integerRepresentation(operand[0], 32);
			oper2=integerRepresentation(operand[1], 32);
			if (formula.contains("+")) {
				temp=integerAddition(oper1, oper2, '0', 32);
			} else if (formula.contains("*")) {

			} else if (formula.contains("/")) {

			} else {

			}
		} else {
			if (formula.contains("+")) {

			} else if (formula.contains("*")) {

			} else if (formula.contains("/")) {

			} else {

			}
		}
		return result;
	}

	// 2
	public String integerRepresentation(String number, int length) {
		String result = "";
		String bin = "";
		int dec = 0;
		String s = "";
		String num = number;

		if (num.charAt(0) == '-') {
			num = num.substring(1);
		}
		for (int i = 0; i < num.length(); i++) {
			dec = dec * 10 + (num.charAt(i) - '0');
		}
		while (dec > 0) {
			bin = dec % 2 + bin;
			dec = dec / 2;
		}
		assert bin.length() <= length;

		for (int i = bin.length(); i < length; i++) {

			bin = "0" + bin;

		}

		if (number.charAt(0) == '-') {
			for (int i = 0; i < length; i++) {
				if (i == length - 1) {
					s += "1";
				} else
					s += "0";
			}
			result = integerAddition(s, negation(bin), '0', length).substring(
					0, length);
		} else {
			result = bin;
		}

		return result;
	}

	// 3
	public String floatRepresentation(String number, int sLength, int eLength) {
		assert sLength >= 8 && eLength >= 8 && number != null;
		double num = 0;
		long dec = 0;
		String decBin = "";
		double sig = 0;
		String sigBin = "";
		int exponent = 0;
		String exponentBin = "";
		String all = "";
		String[] temp = new String[2];
		String result = "";
		String s = "";
		String test = "";
		String precision = "";
		String oper1 = "";
		String all2 = "";
		int standard = (int) Math.pow(2, eLength - 1);
		num = Float.parseFloat(number);

		if (number.contains(".")) {
			temp = number.split("\\.");
			dec = Long.parseLong(temp[0]);
		} else {
			dec = Integer.parseInt(number);
		}
		sig = num - dec;
		if (sig < 0) {
			sig = -sig;
		}
		if (dec < 0) {
			dec = -dec;
		}
		decBin = integerRepresentation(dec + "", standard);
		while (sig > 0) {
			sig *= 2;
			if (sig >= 1) {
				sigBin += "1";
				sig -= 1;
			} else {
				sigBin += "0";
			}
		}
		if (decBin.contains("1")) {
			decBin = decBin.substring(decBin.indexOf("1"));
		} else {
			decBin = "0";
		}
		all = decBin + sigBin;
		exponent = (decBin.length() - 1) - all.indexOf("1") + standard - 1;
		for (int i = all.length(); i < sLength + 2; i++) {
			all += "0";
		}
		precision = all.substring(all.indexOf("1"));
		for (int i = precision.length(); i < sLength + 2; i++) {
			precision += "0";
		}
		precision = precision.substring(0, sLength + 2);
		if (precision.length() > sLength) {
			if (precision.lastIndexOf("1") == (sLength + 1)) {

				all2 = integerAddition("00" + precision, "0", '1', sLength + 4)
						.substring(1, sLength + 4);
				if (all2.charAt(0) == '1') {
					precision = all2.substring(0, sLength + 1);
					exponent += 1;
				} else {
					precision = all2.substring(1, sLength + 2);
				}
			}

		}

		if (exponent >= (standard * 2 - 1)) {
			result = "";
			if (num < 0) {
				result += "1";
			} else {
				result += "0";
			}
			for (int i = 0; i < eLength; i++) {
				result += "1";
			}
			for (int i = 0; i < sLength; i++) {
				result += "0";
			}

		} else if (exponent < (standard * 2 - 1) && exponent > 0) {
			result = "";
			exponentBin = integerRepresentation(exponent + "", eLength);
			if (num < 0) {
				result += "1";
			} else {
				result += "0";
			}
			result += exponentBin;
			precision = precision.substring(1);
			for (int i = precision.length(); i < sLength; i++) {
				precision += "0";
			}
			s = precision.substring(0, sLength);

			result += s;

		} else if (exponent <= 0 && (exponent >= (-(standard - 1) - sLength))) {
			result = "";
			if (num < 0) {
				result += "1";
			} else {
				result += "0";
			}
			for (int i = 0; i < eLength; i++) {
				result += "0";
			}
			for (int i = 0; i < standard - 2; i++) {
				test += "0";
			}
			assert sigBin.contains(test);
			sigBin = sigBin.substring(standard - 2);
			if (sigBin.length() > sLength) {
				sigBin = sigBin.substring(0, sLength);
			} else {
				for (int j = sigBin.length(); j < sLength; j++) {
					sigBin += "0";
				}
			}
			result += sigBin;

		} else if (exponent < (-(standard - 1) - sLength)) {
			result = "";
			if (num < 0) {
				result += "1";
			} else {
				result += "0";
			}
			for (int i = 0; i < eLength; i++) {
				result += "0";
			}
			for (int i = 0; i < sLength; i++) {
				result += "0";
			}
		}

		return result;
	}

	// 4
	public String ieee754(String number, int length) {
		assert (length == 32) || (length == 64);
		String result = "";
		if (length == 32) {
			result = floatRepresentation(number, 23, 8);
		} else if (length == 64) {
			result = floatRepresentation(number, 52, 11);
		}

		return result;
	}

	// 5
	public String integerTrueValue(String oprand) {
		String result = "";
		int dec = 0;
		for (int i = 0; i < oprand.length(); i++) {
			if (i == 0) {
				if (oprand.charAt(i) == '1') {
					dec += (-1);
				}
			} else {
				dec = dec * 2 + (oprand.charAt(i) - '0');
			}
		}

		return result + dec;
	}

	// 6
	public String floatTrueValue(String operand, int sLength, int eLength) {
		assert sLength >= 8 && eLength >= 8 && operand != null
				&& operand.length() == (1 + sLength + eLength);
		String result = "";
		String all = "";
		int exponent = 0;
		String s = "";
		String sLater = "";
		int temp = 0;
		double sig = 0;
		double sigT = 0;
		String sigS = "";

		int standard = (int) (Math.pow(2, eLength - 1));
		all = operand.substring(1);
		s = all.substring(eLength);
		exponent = Integer.parseInt(integerTrueValue("0"
				+ all.substring(0, eLength)))
				- standard + 1;
		if (exponent >= standard) {
			if (s.contains("1")) {
				result = "NaN";
			} else {
				if (operand.charAt(0) == '0')
					result = "+Inf";
				else
					result = "-Inf";
			}
		} else if ((exponent > -(standard - 1)) && exponent < standard) {
			s = "01" + s;
			sLater = s.substring(0, s.lastIndexOf("1") + 1);
			temp = Integer.parseInt(integerTrueValue(sLater));
			sig = temp * Math.pow(2, -(sLater.length() - 2));
			sigT = sig * Math.pow(2, exponent);
			sigS = "" + sigT;
			for (int i = sigS.length() - 1; i >= 0; i--) {
				if (sigS.charAt(i) != '0') {
					if (sigS.charAt(i) == '.') {
						result = sigS.substring(0, i);
						break;
					} else {
						result = sigS.substring(0, i + 1);
						break;
					}
				}
				if (i == 0) {
					result = sigS.substring(0, 1);
					break;
				}
			}

			if (operand.charAt(0) == '1')
				result = "-" + result;

		} else if (exponent == -(standard - 1)) {
			if (s.contains("1")) {
				s = "01" + s;
				temp = Integer.parseInt(integerTrueValue(s));
				sig = temp * Math.pow(2, -sLength);
				sigT = sig - 1;
				sigT = sigT * Math.pow(2, -(standard - 2));
				result = "" + sigT;
				if (operand.charAt(0) == '1')
					result = "-" + result;
			} else {
				result = "0";
			}
		}

		return result;
	}

	// 7
	public String negation(String operand) {
		assert operand != null;
		String result = "";
		for (int i = 0; i < operand.length(); i++) {
			if (operand.charAt(i) == '0') {
				result += '1';
			} else
				result += '0';
		}

		return result;
	}

	// 8
	public String leftShift(String operand, int n) {
		assert n <= operand.length() && n >= 0;
		String result = "";
		for (int i = 0; i < n; i++) {
			result += "0";
		}
		result = operand.substring(n, operand.length()) + result;
		return result;
	}

	// 9
	public String rightAriShift(String operand, int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			if (operand.charAt(0) == '1') {
				result += "1";
			}
			if (operand.charAt(0) == '0') {
				result += "0";
			}
		}
		result += operand.substring(0, operand.length() - n);
		return result;
	}

	// 10
	public String rightLogShift(String operand, int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += "0";
		}
		result += operand.substring(0, operand.length() - n);
		return result;
	}

	// 11
	public String fullAdder(char x, char y, char c) {
		assert (x == '0' || x == '1') && (y == '0' || y == '1')
				&& (c == '0' || c == '1');
		String result = "";
		int temp = 0;
		temp = (x - '0') + (y - '0') + (c - '0');
		switch (temp) {
		case 0:
			result = "00";
			break;
		case 1:
			result = "10";
			break;
		case 2:
			result = "01";
			break;
		case 3:
			result = "11";
			break;
		default:
			break;

		}
		return result;
	}

	// 12
	public String claAdder(String operand1, String operand2, char c) {
		assert (operand1.length() == 8) && (operand2.length() == 8);
		String result = "";
		int[] carry = new int[operand1.length() + 1];
		int[] p = new int[operand1.length() + 1];
		int[] g = new int[operand1.length() + 1];
		int[] temp = new int[operand1.length() + 1];
		char s;

		carry[0] = c - '0';
		for (int i = operand1.length() - 1; i >= 0; i--) {
			if (operand1.charAt(i) == '0' && operand2.charAt(i) == '0') {
				p[operand1.length() - i] = 0;
			} else {
				p[operand1.length() - i] = 1;
			}
			if (operand1.charAt(i) == '1' && operand2.charAt(i) == '1') {
				g[operand1.length() - i] = 1;
			} else {
				g[operand1.length() - i] = 0;
			}
		}
		for (int i = 1; i <= operand1.length(); i++) {
			if (p[i] == 1 && carry[i - 1] == 1)
				temp[i] = 1;
			else
				temp[i] = 0;
			if (temp[i] == 0 && g[i] == 0)
				carry[i] = 0;
			else
				carry[i] = 1;
		}
		for (int i = operand1.length() - 1; i >= 0; i--) {
			s = (carry[operand1.length() - i - 1] + "").charAt(0);
			result = fullAdder(operand1.charAt(i), operand2.charAt(i), s)
					.charAt(0) + result;
		}
		result += carry[operand1.length()];

		return result;
	}

	// 13
	public String integerAddition(String operand1, String operand2, char c,
			int length) {
		assert (operand1.length() <= length) && (operand2.length() <= length)
				&& (operand1 != null) && (operand2 != null);
		String result = "";
		String lens = "";
		String oper1 = operand1;
		String oper2 = operand2;
		int len = 0;
		if (length % 8 == 0) {
			len = length;
		} else {
			len = (length / 8 + 1) * 8;
		}

		String[] temp = new String[len / 8];
		if (operand1.length() < len) {
			for (int j = 0; j < len - operand1.length(); j++) {
				if (operand1.charAt(0) == '0') {
					oper1 = "0" + oper1;
				} else if (operand1.charAt(0) == '1') {
					oper1 = "1" + oper1;
				}
			}
		}

		if (operand2.length() < len) {
			for (int j = 0; j < len - operand2.length(); j++) {
				if (operand2.charAt(0) == '0') {
					oper2 = "0" + oper2;
				} else if (operand2.charAt(0) == '1') {
					oper2 = "1" + oper2;
				}
			}
		}
		for (int k = len / 8 - 1; k >= 0; k--) {
			if (k == len / 8 - 1) {
				temp[k] = claAdder(oper1.substring(8 * k, 8 * (k + 1)),
						oper2.substring(8 * k, 8 * (k + 1)), c);
			} else {
				temp[k] = claAdder(oper1.substring(8 * k, 8 * (k + 1)),
						oper2.substring(8 * k, 8 * (k + 1)),
						temp[k + 1].charAt(8));
			}

		}
		for (int i = 0; i < len / 8; i++) {
			lens += temp[i].substring(0, 8);
		}
		result = lens.substring(len - length);
		if (oper1.charAt(0) != oper2.charAt(0)) {
			result += "0";
		} else {
			if (oper1.charAt(0) == result.charAt(0)) {
				result += "0";
			} else {
				result += "1";
			}
		}

		return result;
	}

	// 14
	public String integerSubtraction(String operand1, String operand2,
			int length) {
		assert (operand1.length() <= length) && (operand2.length() <= length)
				&& (operand1 != null) && (operand2 != null);
		String result = "";
		String s = "";
		String temp = "";
		String oper2 = "";
		int len = 0;
		String operand2Negation = "";
		oper2 = negation(operand2);
		for (int i = 0; i < oper2.length(); i++) {
			if (i == oper2.length() - 1) {
				s += "1";
			} else
				s += "0";
		}
		operand2Negation = integerAddition(s, oper2, '0', oper2.length())
				.substring(0, oper2.length());
		assert operand2Negation != operand2;
		result = integerAddition(operand1, operand2Negation, '0', length);
		return result;
	}

	// 15
	public String integerMultiplication(String operand1, String operand2,
			int length) {
		assert (operand1.length() <= length) && (operand2.length() <= length)
				&& (operand1 != null) && (operand2 != null);
		String result = "";
		String oper1 = operand1;
		String oper2 = operand2;
		String oper1N = "";
		String s = "";
		String zero = "";
		String oper1Negation = "";
		String all = "";
		String temp = "";
		if (operand1.length() < length) {
			for (int j = 0; j < length - operand1.length(); j++) {
				if (operand1.charAt(0) == '0') {
					oper1 = "0" + oper1;
				} else if (operand1.charAt(0) == '1') {
					oper1 = "1" + oper1;
				}
			}
		}
		if (operand2.length() < length) {
			for (int j = 0; j < length - operand2.length(); j++) {
				if (operand2.charAt(0) == '0') {
					oper2 = "0" + oper2;
				} else if (operand2.charAt(0) == '1') {
					oper2 = "1" + oper2;
				}
			}
		}
		oper1N = negation(oper1);
		for (int i = 0; i < oper1.length(); i++) {
			if (i == oper1.length() - 1) {
				s += "1";
			} else
				s += "0";
		}
		oper1Negation = integerAddition(s, oper1N, '0', oper1.length())
				.substring(0, oper1N.length());
		all = oper2;
		for (int i = all.length(); i < length * 2; i++) {
			all = "0" + all;
		}
		all += "0";
		for (int j = 0; j < length; j++) {
			zero += "0";
		}
		for (int i = 0; i < length; i++) {
			if (all.charAt(length * 2) - all.charAt(length * 2 - 1) == -1) {
				temp = integerAddition(oper1Negation, all.substring(0, length),
						'0', length);
			} else if (all.charAt(length * 2) - all.charAt(length * 2 - 1) == 1) {
				temp = integerAddition(oper1, all.substring(0, length), '0',
						length);
			} else if (all.charAt(length * 2) - all.charAt(length * 2 - 1) == 0) {
				temp = integerAddition(zero, all.substring(0, length), '0',
						length);
			}
			StringBuffer sb = new StringBuffer(all);
			sb.replace(0, length, temp.substring(0, temp.length() - 1));
			all = sb.toString();
			all = rightAriShift(all, 1);
		}
		result = all.substring(0, length * 2);
		return result;
	}

	// 16
	public String intergerDivision(String operand1, String operand2, int length) {
		assert (operand1.length() <= length) && (operand2.length() <= length)
				&& (operand1 != null) && (operand2 != null);
		String result = "";
		String oper1 = operand1;
		String oper2 = operand2;
		String s = "";
		String quotient = "";
		String all = "";
		String temp = "";
		String quotientN = "";
		if (operand1.length() < length) {
			for (int j = 0; j < length - operand1.length(); j++) {
				if (operand1.charAt(0) == '0') {
					oper1 = "0" + oper1;
				} else if (operand1.charAt(0) == '1') {
					oper1 = "1" + oper1;
				}
			}
		}
		if (operand2.length() < length) {
			for (int j = 0; j < length - operand2.length(); j++) {
				if (operand2.charAt(0) == '0') {
					oper2 = "0" + oper2;
				} else if (operand2.charAt(0) == '1') {
					oper2 = "1" + oper2;
				}
			}
		}
		all = oper1;
		for (int i = all.length(); i < length * 2; i++) {
			if (oper1.charAt(0) == '0')
				all = "0" + all;
			else
				all = "1" + all;
		}
		for (int i = 0; i < length; i++) {
			temp = "";
			all = all.substring(1, all.length());
			if (all.charAt(0) == oper2.charAt(0)) {
				temp = integerSubtraction(all.substring(0, length), oper2,
						length).substring(0, length);
			} else {
				temp = integerAddition(all.substring(0, length), oper2, '0',
						length).substring(0, length);
			}
			if (temp.charAt(0) == all.charAt(0)) {
				StringBuffer sb = new StringBuffer(all);
				sb.replace(0, length, temp);
				all = sb.toString();
				all += "1";
			} else {
				all += "0";
			}
		}
		quotient = all.substring(length, length * 2);

		if (oper2.charAt(0) != oper1.charAt(0)) {
			for (int i = 0; i < length; i++) {
				if (i == length - 1) {
					s += "1";
				} else
					s += "0";
			}
			quotientN = negation(quotient);
			quotient = integerAddition(s, quotientN, '0', length).substring(0,
					length);
		}
		result = quotient + all.substring(0, length);

		return result;
	}

	// 17
	public String floatAddition(String operand1, String operand2, int sLength,
			int eLength, int gLength) {
		assert operand1 != null && operand2 != null && sLength >= 0
				&& eLength >= 0;
		String result = "";
		String eS1 = "";
		String eS2 = "";
		String sigS1 = "";
		String sigS2 = "";
		String sigT = "";
		String sigS = "";
		String sigST = "";
		String rS = "";
		int eInt1 = 0;
		int eInt2 = 0;
		int eMax = 0;
		int standard = (int) (Math.pow(2, eLength - 1));
		boolean isOverflow = true;
		eS1 = operand1.substring(1, eLength + 1);
		eS2 = operand2.substring(1, eLength + 1);
		eInt1 = Integer.parseInt(integerTrueValue("0" + eS1));
		eInt2 = Integer.parseInt(integerTrueValue("0" + eS2));
		if (!(operand1.substring(1, 1 + eLength).contains("1"))
				&& operand1.substring(1 + eLength, 1 + eLength + sLength)
						.contains("1")) {
			eInt1++;
		}
		if (!(operand2.substring(1, 1 + eLength).contains("1"))
				&& operand2.substring(1 + eLength, 1 + eLength + sLength)
						.contains("1")) {
			eInt2++;
		}
		if (eS1.contains("1"))
			sigS1 = "1"
					+ operand1.substring(eLength + 1, 1 + eLength + sLength);
		else
			sigS1 = "0"
					+ operand1.substring(eLength + 1, 1 + eLength + sLength);

		if (eS2.contains("1"))
			sigS2 = "1"
					+ operand2.substring(eLength + 1, 1 + eLength + sLength);
		else
			sigS2 = "0"
					+ operand2.substring(eLength + 1, 1 + eLength + sLength);

		for (int i = 0; i < gLength; i++) {
			sigS1 += "0";
			sigS2 += "0";
		}

		if (!(operand1.substring(1).contains("1"))) {
			result = operand2 + "0";
		} else {
			if (!(operand2.substring(1).contains("1"))) {
				result = operand1 + "0";
			} else {
				eMax = Math.max(eInt1, eInt2);
				while (eInt1 < eMax
						&& (sigS1.substring(0, sLength + 1)).contains("1")) {
					sigS1 = rightLogShift(sigS1, 1);
					eInt1++;
				}
				while (eInt2 < eMax
						&& (sigS2.substring(0, sLength + 1)).contains("1")) {
					sigS2 = rightLogShift(sigS2, 1);
					eInt2++;
				}

				if (!((sigS1.substring(0, sLength + 1)).contains("1"))) {
					result = operand2 + "0";
				} else {
					if (!((sigS2.substring(0, sLength + 1)).contains("1"))) {
						result = operand1 + "0";
					} else {
						if (sigS1.contains("1") && sigS2.contains("1")
								&& eInt1 == eInt2) {
							if (operand1.charAt(0) != operand2.charAt(0)) {
								sigS2 = integerAddition("0", negation(sigS2),
										'1', sigS1.length()).substring(0,
										sigS1.length());
							}

							sigS = integerAddition(sigS1, sigS2, '0',
									sigS1.length());

							if (operand1.charAt(0) == operand2.charAt(0)) {
								if (sigS.charAt(sigS1.length()) == '1') {
									sigST = sigS.charAt(sigS1.length())
											+ sigS.substring(0, sLength
													+ gLength);
									eMax++;
									if (eMax >= (standard * 2 - 1)) {
										if (operand1.charAt(0) == '0')
											result += "0";
										else
											result += "1";
										result += (integerRepresentation(
												(standard * 2 - 1) + "",
												eLength + 1).substring(1,
												eLength + 1));
										for (int i = 0; i < sLength; i++) {
											result += "0";
										}
										result += "1";
									}
								} else {
									sigST = sigS.substring(0, 1 + sLength
											+ gLength);
								}
							} else {
								if (sigS.charAt(sigS1.length()) == '1') {
									sigST = sigS.substring(0, 1 + sLength
											+ gLength);
								} else {
									isOverflow = false;
									sigST = integerAddition("0",
											negation(sigST), '1',
											sigST.length()).substring(0,
											1 + sLength + gLength);
								}
							}

							if (!(sigST.contains("1"))) {
								for (int i = 0; i < 1 + eLength + sLength; i++) {
									result += "0";
								}
							} else {
								eMax = eMax - sigST.indexOf("1");
								if (eMax >= (standard * 2 - 1)) {
									if (isOverflow) {
										result += operand1.charAt(0);
									} else {
										if (operand1.charAt(0) == '0')
											result += "1";
										else
											result += "0";
									}
									result += (integerRepresentation(
											(standard * 2 - 1) + "",
											eLength + 1).substring(1,
											eLength + 1));
									for (int i = 0; i < sLength; i++) {
										result += "0";
									}
									result += "1";
								} else if (eMax > 0
										&& eMax < (standard * 2 - 1)) {
									sigT = sigST.substring(sigST.indexOf("1"));
									if (sigT.length() > 1 + sLength) {
										if (sigT.charAt(1 + sLength) == '1') {
											rS = "0"
													+ integerRepresentation(
															eMax + "",
															eLength + 1)
															.substring(1,
																	1 + eLength)
													+ sigT.substring(1,
															1 + sLength + 1);
											rS = rounding(rS, sLength, eLength,
													1);
											if (rS.substring(1, 1 + eLength)
													.contains("1"))
												sigT = "1"
														+ rS.substring(
																1 + eLength,
																1
																		+ eLength
																		+ sLength);
											else
												sigT = "0"
														+ rS.substring(
																1 + eLength,
																1
																		+ eLength
																		+ sLength);
											eMax = Integer.parseInt("0"
													+ rS.substring(1,
															1 + eLength));

										}
									}
									for (int i = sigT.length(); i <= 1 + sLength; i++) {
										sigT += "0";
									}
									sigT = sigT.substring(0, 1 + sLength);
									if (isOverflow) {
										result += operand1.charAt(0);
									} else {
										if (operand1.charAt(0) == '0')
											result += "1";
										else
											result += "0";
									}
									result += (integerRepresentation(
											"0" + eMax, eLength + 1).substring(
											1, eLength + 1));
									result += sigT.substring(1, 1 + sLength);
									result += "0";
								} else if (eMax <= 0 && eMax >= 1 - sLength) {
									sigT = rightLogShift(sigT, 1);
									// 暂未写就近舍入

									if (isOverflow) {
										result += operand1.charAt(0);
									} else {
										if (operand1.charAt(0) == '0')
											result += "1";
										else
											result += "0";
									}
									for (int i = 0; i < eLength; i++) {
										result += "0";
									}
									result += sigT.substring(1, 1 + sLength);
									result += "0";
								} else if (eMax < 1 - sLength) {
									if (isOverflow) {
										result += operand1.charAt(0);
									} else {
										if (operand1.charAt(0) == '0')
											result += "1";
										else
											result += "0";
									}
									for (int i = 0; i < eLength + sLength; i++) {
										result += "0";
									}
									result += "1";
								}

							}
						}
					}
				}

			}
		}

		return result;
	}

	// 18
	public String floatSubtraction(String operand1, String operand2,
			int sLength, int eLength, int gLength) {
		String result = "";
		String operand2N = "";
		if (operand2.charAt(0) == '0')
			operand2N = "1" + operand2.substring(1);
		else
			operand2N = "0" + operand2.substring(1);
		result = floatAddition(operand1, operand2N, sLength, eLength, gLength);
		return result;
	}

	// 19
	public String floatMultiplication(String operand1, String operand2,
			int sLength, int eLength) {
		assert sLength >= 8 && eLength >= 8
				&& operand1.length() == (1 + eLength + sLength)
				&& operand2.length() == (1 + eLength + sLength);
		String result = "";
		String eS1 = "";
		String eS2 = "";
		String sigS1 = "";
		String sigS2 = "";
		String sigT = "";
		String sigS = "";
		String sigST = "";
		String rS = "";
		int eInt1 = 0;
		int eInt2 = 0;
		int eInt = 0;
		int standard = (int) (Math.pow(2, eLength - 1));

		eS1 = operand1.substring(1, eLength + 1);
		eS2 = operand2.substring(1, eLength + 1);
		eInt1 = Integer.parseInt(integerTrueValue("0" + eS1));
		eInt2 = Integer.parseInt(integerTrueValue("0" + eS2));
		if (!(operand1.substring(1, 1 + eLength).contains("1"))
				&& operand1.substring(1 + eLength, 1 + eLength + sLength)
						.contains("1")) {
			eInt1++;
		}
		if (!(operand2.substring(1, 1 + eLength).contains("1"))
				&& operand2.substring(1 + eLength, 1 + eLength + sLength)
						.contains("1")) {
			eInt2++;
		}
		if ((!(operand1.substring(1).contains("1")))
				|| (!(operand2.substring(1).contains("1")))) {
			for (int i = 0; i < 1 + eLength + sLength; i++) {
				result += "0";
			}
		} else {
			eInt = eInt1 + eInt2 - (standard - 1);
			if (eS1.contains("1"))
				sigS1 = "1"
						+ operand1
								.substring(1 + eLength, 1 + eLength + sLength);
			else
				sigS1 = "0"
						+ operand1
								.substring(1 + eLength, 1 + eLength + sLength);
			if (eS2.contains("1"))
				sigS2 = "1"
						+ operand2
								.substring(1 + eLength, 1 + eLength + sLength);
			else
				sigS2 = "0"
						+ operand2
								.substring(1 + eLength, 1 + eLength + sLength);
			sigS = integerMultiplication("0" + sigS1, "0" + sigS2, 2 + sLength);

			eInt = eInt + (3 - sigS.indexOf("1"));
			sigST = sigS;
			if (eInt >= (standard * 2 - 1)) {
				if (operand1.charAt(0) == operand2.charAt(0))
					result += "0";
				else
					result += "1";
				for (int i = 0; i < eLength + sLength; i++) {
					if (i < eLength)
						result += "1";
					else
						result += "0";
				}
			} else if (eInt < (1 - sLength)) {
				if (operand1.charAt(0) == operand2.charAt(0))
					result += "0";
				else
					result += "1";
				for (int i = 0; i < eLength + sLength; i++) {
					result += "0";
				}
			} else if (eInt > 0 && eInt < (standard * 2 - 1)) {
				sigT = sigST.substring(sigST.indexOf("1"));
				for (int i = sigT.length(); i < 1 + sLength; i++) {
					sigT += "0";
				}
				if (sigT.length() > 1 + sLength) {
					if (sigT.charAt(1 + sLength) == '1') {
						rS = "0"
								+ integerRepresentation(eInt + "", eLength + 1)
										.substring(1, 1 + eLength)
								+ sigT.substring(1, 1 + sLength + 1);
						rS = rounding(rS, sLength, eLength, 1);
						if (rS.substring(1, 1 + eLength).contains("1"))
							sigT = "1"
									+ rS.substring(1 + eLength, 1 + eLength
											+ sLength);
						else
							sigT = "0"
									+ rS.substring(1 + eLength, 1 + eLength
											+ sLength);
						eInt = Integer.parseInt("0"
								+ rS.substring(1, 1 + eLength));

					}
				}
				sigT = sigT.substring(0, 1 + sLength);
				if (operand1.charAt(0) == operand2.charAt(0))
					result += "0";
				else
					result += "1";
				result += integerRepresentation(eInt + "", eLength + 1)
						.substring(1, 1 + eLength);
				result += sigT.substring(1, 1 + sLength);
			} else if (eInt <= 0 && eInt >= (1 - sLength)) {
				sigT = sigST.substring(sigST.indexOf("1"));
				for (int i = sigT.length(); i < 1 + sLength; i++) {
					sigT += "0";
				}
				if (sigT.length() > 1 + sLength) {
					if (sigT.charAt(1 + sLength) == '1') {
						rS = "0"
								+ integerRepresentation(eInt + "", eLength + 1)
										.substring(1, 1 + eLength)
								+ sigT.substring(1, 1 + sLength + 1);
						rS = rounding(rS, sLength, eLength, 1);
						if (rS.substring(1, 1 + eLength).contains("1"))
							sigT = "1"
									+ rS.substring(1 + eLength, 1 + eLength
											+ sLength);
						else
							sigT = "0"
									+ rS.substring(1 + eLength, 1 + eLength
											+ sLength);
						eInt = Integer.parseInt("0"
								+ rS.substring(1, 1 + eLength));

					}
				}
				sigT = sigT.substring(0, 1 + sLength);
				if (operand1.charAt(0) == operand2.charAt(0))
					result += "0";
				else
					result += "1";
				for (int i = 0; i < eLength; i++) {
					result += "0";
				}
				result += sigT.substring(1, 1 + sLength);
			}

		}

		return result;
	}

	// 20
	public String floatDivision(String operand1, String operand2, int sLength,
			int eLength) {
		assert sLength >= 8 && eLength >= 8
				&& operand1.length() == (1 + eLength + sLength)
				&& operand2.length() == (1 + eLength + sLength);
		String result = "";
		String eS1 = "";
		String eS2 = "";
		String sigS1 = "";
		String sigS2 = "";
		String sigT = "";
		String sigST = "";
		String all = "";
		String temp = "";
		String temp1 = "";
		int eInt1 = 0;
		int eInt2 = 0;
		int eInt = 0;
		int standard = (int) (Math.pow(2, eLength - 1));
		eS1 = operand1.substring(1, eLength + 1);
		eS2 = operand2.substring(1, eLength + 1);
		eInt1 = Integer.parseInt(integerTrueValue("0" + eS1));
		eInt2 = Integer.parseInt(integerTrueValue("0" + eS2));
		if (!(operand1.substring(1, 1 + eLength).contains("1"))
				&& operand1.substring(1 + eLength, 1 + eLength + sLength)
						.contains("1")) {
			eInt1++;
		}
		if (!(operand2.substring(1, 1 + eLength).contains("1"))
				&& operand2.substring(1 + eLength, 1 + eLength + sLength)
						.contains("1")) {
			eInt2++;
		}
		if ((!(operand1.substring(1).contains("1")))
				&& (!(operand2.substring(1).contains("1")))) {
			result = "NaN";
		} else if ((!(operand1.substring(1).contains("1")))) {
			result += operand1.charAt(0);
			for (int i = 1; i < 1 + eLength + sLength; i++) {
				result += "0";
			}
		} else if ((!(operand2.substring(1).contains("1")))) {
			result += operand1.charAt(0);
			for (int i = 0; i < sLength + eLength; i++) {
				if (i < eLength)
					result += "1";
				else
					result += "0";
			}
		} else {
			eInt = eInt1 - eInt2 + (standard - 1);
			if (eS1.contains("1"))
				sigS1 = "1"
						+ operand1
								.substring(1 + eLength, 1 + eLength + sLength);
			else
				sigS1 = "0"
						+ operand1
								.substring(1 + eLength, 1 + eLength + sLength);
			if (eS2.contains("1"))
				sigS2 = "1"
						+ operand2
								.substring(1 + eLength, 1 + eLength + sLength);
			else
				sigS2 = "0"
						+ operand2
								.substring(1 + eLength, 1 + eLength + sLength);
			all = sigS1;
			for (int i = all.length(); i < sigS1.length() * 2; i++) {
				all += "0";
			}
			for (int i = 0; i < sigS1.length(); i++) {
				if (all.substring(0, 1 + sLength).compareTo(sigS2) >= 0) {
					temp = integerSubtraction(all.substring(0, 1 + sLength),
							sigS2, 1 + sLength).substring(0, sLength + 1);
					temp1 = temp
							+ all.substring(1 + sLength, (1 + sLength) * 2)
							+ "1";
					all = leftShift(temp1, 1).substring(0, (1 + sLength) * 2);
				} else {

					all = leftShift(all, 1).substring(0, (1 + sLength) * 2);
				}

			}
			sigST = all.substring(1 + sLength, 2 * (1 + sLength));
			eInt = eInt - sigST.indexOf("1");
			if (eInt >= (standard * 2 - 1)) {
				if (operand1.charAt(0) == operand2.charAt(0))
					result += "0";
				else
					result += "1";
				for (int i = 0; i < eLength + sLength; i++) {
					if (i < eLength)
						result += "1";
					else
						result += "0";
				}
			} else if (eInt < (1 - sLength)) {
				if (operand1.charAt(0) == operand2.charAt(0))
					result += "0";
				else
					result += "1";
				for (int i = 0; i < eLength + sLength; i++) {
					result += "0";
				}
			} else if (eInt > 0 && eInt < (standard * 2 - 1)) {
				sigT = sigST.substring(sigST.indexOf("1"));
				for (int i = sigT.length(); i < 1 + sLength; i++) {
					sigT += "0";
				}
				sigT = sigT.substring(0, 1 + sLength);
				if (operand1.charAt(0) == operand2.charAt(0))
					result += "0";
				else
					result += "1";
				result += integerRepresentation(eInt + "", eLength + 1)
						.substring(1, 1 + eLength);
				result += sigT.substring(1, 1 + sLength);
			} else if (eInt <= 0 && eInt >= (1 - sLength)) {
				sigT = sigST.substring(sigST.indexOf("1"));
				for (int i = sigT.length(); i < 1 + sLength; i++) {
					sigT += "0";
				}
				sigT = sigT.substring(0, 1 + sLength);
				if (operand1.charAt(0) == operand2.charAt(0))
					result += "0";
				else
					result += "1";
				for (int i = 0; i < eLength; i++) {
					result += "0";
				}
				result += sigT.substring(1, 1 + sLength);
			}

		}

		return result;
	}

	// extra
	public String rounding(String operand, int sLength, int eLength, int gLength) {
		assert operand.length() >= (1 + sLength + eLength + gLength)
				&& gLength > 0;
		String result = "";
		String sig = "";
		String sigL = "";
		String sigT = "";
		String exponent = "";
		int eInt = 0;
		operand = operand.substring(0, 1 + eLength + sLength + gLength);
		exponent = operand.substring(1, 1 + eLength);
		if (exponent.contains("1"))
			sigL = "1"
					+ operand.substring(1 + eLength, 1 + eLength + sLength + 1);
		else
			sigL = "0"
					+ operand.substring(1 + eLength, 1 + eLength + sLength + 1);

		eInt = Integer.parseInt(integerTrueValue("0" + exponent));
		if (sigL.charAt(sLength + 1) == '1') {
			sigT = integerAddition("00" + sigL, "0", '1', sLength + 4)
					.substring(1, sLength + 4);
			if (sigT.charAt(0) == '1') {
				sig = sigT.substring(0, sLength + 1);
				eInt++;
			} else {
				sig = sigT.substring(1, 2 + sLength);
			}

		} else {
			sig = sigL.substring(0, 1 + sLength);
		}

		if (operand.charAt(0) == '0') {
			result += '0';
		} else {
			result += "1";
		}
		result += (integerRepresentation(eInt + "", eLength + 1).substring(1,
				eLength + 1));
		result += sig.substring(1);

		return result;
	}

}
