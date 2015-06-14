
public class IntegerMultiplicationQuick {
	// 15.0
		public String integerMultiplicationQuick(String operand1, String operand2,
				int length) {
			assert (operand1.length() <= length) && (operand2.length() <= length)
					&& (operand1 != null) && (operand2 != null);
			String result = "";
			String oper1 = operand1;
			String oper2 = operand2;
			String oper1N = "";
			String oper1Negation = "";
			String all = "";
			String temp = "";
			int lengths = 0;
			int y0 = 0;
			int y1 = 0;
			int y2 = 0;
			int judge = 0;
			if (length % 2 != 0) {
				lengths = length + 1;
			} else {
				lengths = length+2;
			}
			if (operand1.length() < lengths) {
				for (int j = 0; j < lengths - operand1.length(); j++) {
					if (operand1.charAt(0) == '0') {
						oper1 = "0" + oper1;
					} else if (operand1.charAt(0) == '1') {
						oper1 = "1" + oper1;
					}
				}
			}
			if (operand2.length() < lengths) {
				for (int j = 0; j < lengths - operand2.length(); j++) {
					if (operand2.charAt(0) == '0') {
						oper2 = "0" + oper2;
					} else if (operand2.charAt(0) == '1') {
						oper2 = "1" + oper2;
					}
				}
			}
			oper1N = negation(oper1);
			oper1Negation = integerAddition("0", oper1N, '1', oper1.length())
					.substring(0, oper1N.length());
			all = oper2;
			for (int i = all.length(); i < lengths * 2; i++) {
				all = "0" + all;
			}
			all += "0";

			for (int i = 0; i < lengths / 2; i++) {
				y0 = Integer.parseInt(all.charAt(lengths * 2) + "");
				y1 = Integer.parseInt(all.charAt(lengths * 2 - 1) + "");
				y2 = Integer.parseInt(all.charAt(lengths * 2 - 2) + "");
				judge = y0 + y1 - 2 * y2;
				if (judge == -2) {
					temp = integerAddition(leftShift(oper1Negation, 1),
							all.substring(0, lengths), '0', lengths);
				} else if (judge == -1) {
					temp = integerAddition(oper1Negation,
							all.substring(0, lengths), '0', lengths);
				} else if (judge == 0) {
					temp = integerAddition("0", all.substring(0, lengths), '0',
							lengths);
				} else if (judge == 1) {
					temp = integerAddition(oper1, all.substring(0, lengths), '0',
							lengths);
				} else if (judge == 2) {
					temp = integerAddition(leftShift(oper1, 1),
							all.substring(0, lengths), '0', lengths);
				}

				StringBuffer sb = new StringBuffer(all);
				sb.replace(0, lengths, temp.substring(0, temp.length() - 1));
				all = sb.toString();
				all = rightAriShift(all, 2);
			}

			if (length % 2 != 0) {
				result = all.substring(2, lengths * 2);
			} else {
				result = all.substring(4, lengths * 2);
			}
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

}
