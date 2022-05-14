package DoubleWeekly75;

public class Q2 {
	public static void main(String[] args) {
		Solution test = new Q2().new Solution();
		System.out.println(test.triangularSum(new int[]{5}));
	}
	class Solution {
		public int triangularSum(int[] nums) {
			for (int i = 1; i <= nums.length; i++) {
				for (int j = 0; j < nums.length - i; j++) {
					nums[j] = (nums[j] + nums[j + 1]) % 10;
				}
			}
			return nums[0];
		}
	}
}
