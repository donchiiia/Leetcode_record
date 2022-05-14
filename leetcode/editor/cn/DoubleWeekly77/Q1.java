package DoubleWeekly77;

import java.net.Socket;

public class Q1 {
	public static void main(String[] args) {
		Solution solution = new Q1().new Solution();
		System.out.println(solution.countPrefixes(new String[]{"a", "a"}, "aa"));
	}
	class Solution {
		public int countPrefixes(String[] words, String s) {
			int sum = 0;
			byte[] bytes = s.getBytes();
			for (int i = 1; i <= s.length(); i++) {
				String s1 = new String(bytes, 0, i);
				for (String word : words) {
					if (word.equals(s1)) sum++;
				}
			}
			return sum;
		}
	}
}
