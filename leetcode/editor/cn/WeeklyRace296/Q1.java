package WeeklyRace296;

public class Q1 {
	public static void main(String[] args) {
		Solution solution = new Q1().new Solution();
		System.out.println(solution.minMaxGame(new int[]{3}));
	}
	class Solution {
		public int minMaxGame(int[] nums) {
			int len = nums.length;
			if (len == 1) {
				return nums[0];
			} else {
				int[] ints = new int[len / 2];
				for (int i = 0; i < ints.length; i++) {
					if (i % 2 == 0) ints[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
					else ints[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
				}
				return minMaxGame(ints);
			}
		}
	}
}
