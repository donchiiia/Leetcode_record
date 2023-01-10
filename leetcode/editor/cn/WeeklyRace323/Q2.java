package editor.cn.WeeklyRace323;

import java.lang.invoke.VarHandle;
import java.util.Arrays;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
		System.out.println(solution.longestSquareStreak(new int[]{2,3,5,6,7}));
	}
	class Solution{
		public int longestSquareStreak(int[] nums) {
			Arrays.sort(nums);
			int n = nums.length, maxNum = nums[n - 1], len = -1;
			int[] dp = new int[maxNum + 1];
			for (int num : nums) {
				dp[num] = 1;
			}
			for (int num : nums) {
				// 排除所有非平方数
				int x = (int) Math.sqrt(num);
				if (x * x != num) continue;
				dp[num] = dp[x] + 1;
			}

			Arrays.sort(dp);
			return dp[maxNum] < 2 ? -1 : dp[maxNum];
		}
	}
}
