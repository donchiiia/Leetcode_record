package WeeklyRace284;

public class Q3 {
	public static void main(String[] args) {
		Solution solution = new Q3().new Solution();
		System.out.println(solution.maximumTop(new int[]{5,2,2,4,0,6}, 4));
	}
	class Solution {
		public int maximumTop(int[] nums, int k) {
			int length = nums.length;

			//如果长度为1，奇数次操作后一定为空栈
			if (length == 1 && k % 2 == 1) {
				return -1;
			}
			int max = (k < length)?nums[k] : 0;
			for (int i = 0; i < Math.min(length, k - 1); i++) {
				max = Math.max(max, nums[i]);
			}
			return max;
		}
	}
}
