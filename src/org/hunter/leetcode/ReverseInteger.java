package org.hunter.leetcode;

public class ReverseInteger{

	public int reverse(int x) {
		StringBuffer s = new StringBuffer(String.valueOf(x).replace("-", ""));

		s.reverse();

		while (s.toString().startsWith("0")) {
			s.delete(0, 1);
		}

		if (s.length() == 0) {
			s.append("0");
		}

		if (x > 0 && Long.valueOf(s.toString()) > Integer.MAX_VALUE) {
			return 0;
		}
		else if (x < 0 && Long.valueOf("-" + s.toString()) < Integer.MIN_VALUE) {
			return 0;
		}

		return x < 0 ? Integer.valueOf("-" + s.toString()) : Integer.valueOf(s.toString());
	}

	public static void main(String [] args) {

		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(1534236469));
	}

}
