package DoubleWeekly79;

import java.util.HashMap;

public class Q1 {
	public static void main(String[] args) {
		Solution solution = new Q1().new Solution();
		System.out.println(solution.digitCount("1210"));
	}
	class Solution {
		public boolean digitCount(String num) {
			HashMap<Integer, Integer> map = new HashMap<>();
			for (char c : num.toCharArray()) {
				map.merge(c - '0', 1, Integer::sum);
			}
			char[] array = num.toCharArray();
			for (Integer i : map.keySet()) {
				if (i >= array.length || array[i] - '0' != map.get(i)) return false;
			}
			return true;
		}
	}
}
