package DoubleWeekly77;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import java.util.ArrayList;
import java.util.Hashtable;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
		System.out.println(solution.minimumAverageDifference(new int[]{2,5,3,9,5,3}));
	}
	class Solution {
		public int minimumAverageDifference(int[] nums) {
			int total = 0, minIndex = 0, minAvg = Integer.MAX_VALUE;
			int[] st = new int[nums.length + 1];
			st[0] = 0;

			for (int i = 1; i <= nums.length; i++) {
				st[i] = st[i - 1] + nums[i - 1];
			}
			for (int i = 1; i < nums.length; i++) {
				int temp = Math.abs((st[i] / i) - ((st[nums.length] - st[i]) / (nums.length - i)));
				if (minAvg > temp) {
					minAvg = temp;
					minIndex = i - 1;
				}
			}
			return minAvg > (st[nums.length] / nums.length) ? nums.length - 1 : minIndex;
		}
	}
}
