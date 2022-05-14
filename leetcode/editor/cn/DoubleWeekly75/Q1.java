package DoubleWeekly75;

import java.util.Spliterator;

public class Q1 {
	public static void main(String[] args) {
		Solution test = new Q1(). new Solution();
		System.out.println(test.minBitFlips(3, 4));
	}
	class Solution {
		public int minBitFlips(int start, int goal) {
			int mid = start ^ goal, test = 1, count = 0;
			for (int i = 0; i < 32; i++) {
				if ((mid & test) != 0) count++;
				test <<= 1;
			}
			return count;
		}
	}
}
