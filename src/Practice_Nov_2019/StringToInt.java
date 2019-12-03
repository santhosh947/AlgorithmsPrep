package Practice_Nov_2019;

import java.util.Stack;

public class StringToInt {
	public static void main(String[] args) {

		 System.out.println(myAtoi("2147483648"));// 42
		System.out.println(myAtoi("   -42")); // -42
		/*
		 * System.out.println(myAtoi("+-2"));
		 * System.out.println(myAtoi("  0000000000012345678"));
		 * System.out.println(myAtoi("   -42")); // -42
		 * System.out.println(myAtoi("4193 with words")); // 4193
		 * System.out.println(myAtoi("words and 987")); // 0
		 * System.out.println(myAtoi("-91283472332")); // -2147483648
		 * System.out.println(myAtoi("3.14159")); // -2147483648
		 * System.out.println(myAtoi("+1")); // -2147483648
		 */
		/*
		 * System.out.println(reverse2(123)); System.out.println(reverse2(-123));
		 * System.out.println(reverse2(120));
		 */

	}

	public static int myAtoi_outside(String str) {
		if (str.isEmpty())
			return 0;
		int sign = 1, base = 0, i = 0;
		while (str.charAt(i) == ' ')
			i++;
		if (str.charAt(i) == '-' || str.charAt(i) == '+')
			sign = str.charAt(i++) == '-' ? -1 : 1;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			base = 10 * base + (str.charAt(i++) - '0');
		}
		return base * sign;
	}

	public static int myAtoi_mycode(String str) {
		if (str == null)
			return 0;
		long holder = 1;
		int res = 0;
		boolean isNegative = false;
		int firstDigit = 0;
		boolean decideSign = false;
		int prevCount = 0;
		Stack st = new Stack();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			boolean isNum = false;

			if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
					|| c == '9' || c == '-' || c == '+') {

				if (firstDigit == 0 && c == '0')
					continue;
				else if (c != '-' && c != '+') {
					st.add(c);

					firstDigit++;
					isNum = true;
				} else if (c == '-' && firstDigit == 0 && !decideSign) {
					isNegative = true;
					decideSign = true;
				} else if (c == '+' && firstDigit == 0 && !decideSign) {
					isNegative = false;
					decideSign = true;
				} else if (decideSign && (c == '-' || c == '+')) {
					return 0;
				} else {
					break;
				}
			}

			else if (firstDigit == 0 && !Character.isWhitespace(c)) {
				return 0;
			}

			else if (firstDigit == prevCount && !Character.isWhitespace(c) && !isNum) {
				break;
			}

			prevCount = firstDigit;

		}

		while (!st.isEmpty()) {
			char c = (char) st.pop();
			res = res + Integer.parseInt(String.valueOf(c)) * (int) holder;
			holder *= 10;
			if (holder > Integer.MAX_VALUE)
				if (isNegative)
					return Integer.MIN_VALUE;
				else
					return Integer.MAX_VALUE;
		}

		if (isNegative)
			res *= -1;

		return res;

	}

	public static int reverse2(int x) {
		long res = 0;
		int holder = 1;
		boolean isneg = false;
		if (x < 0) {
			isneg = true;
			x *= -1;
		}

		int rem = x % 10;

		while (x > 0) {

			res = res * 10 + rem;
			x = x / 10;
			rem = x % 10;
		}

		if (isneg)
			res *= -1;

		if (res > Integer.MAX_VALUE)
			return 0;

		if (res < Integer.MIN_VALUE)
			return 0;

		return (int) res;

	}

	public static int myAtoi(String str) {
		int res = 0;
		if (str == null)
			return 0;
		
		if(str.isEmpty())
			return 0;

		int sign = 1, i = 0;

		long base = 0;
		while (i<str.length() && str.charAt(i) == ' ') {
			i++;
		}
		// find the sign
        if(i<str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+'))
        {
			sign = str.charAt(i++) == '-' ? -1 : 1;
		}

		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			base = base * 10 + str.charAt(i++) - '0';
            if(base > Integer.MAX_VALUE || base < Integer.MIN_VALUE)
            {
                return (sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE);
            }
		}

		res = sign * (int) base;
		return res;
	}
}