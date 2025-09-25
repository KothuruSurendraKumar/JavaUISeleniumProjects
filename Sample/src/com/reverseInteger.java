package com;

public class reverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int num = 1534236469;
//		int num2 = 1234;
//		int rev = reverseInt(num2);
//		System.out.println(rev);

		String s = "       -1337c0d3";
		int n = converToInt(s);
		System.out.println(n);

	}

	private static int converToInt(String s) {
		// TODO Auto-generated method stub
		s = s.trim();
		boolean isNegetive = false;
		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '-') {
				if (i == 0) {
					isNegetive = true;
				} else {
					break;
				}
			}else if(Character.isDigit(ch)) {
				int dig = ch - '0';
				res = res * 10 + dig;
			}else {
				break;
			}
			
		}
		return isNegetive ? -res : res;
	}

	private static int reverseInt(int num) {
		// TODO Auto-generated method stub

		int rev = 0;
		while (num != 0) {
			int dig = num % 10;
			if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && dig > 7) {
				return 0;
			}
			if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && dig < -8) {
				return 0;
			}
			rev = rev * 10 + dig;
			num = num / 10;
		}

		return rev;
	}

}
