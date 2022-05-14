package WeeklyRace291;

import java.util.Arrays;

public class Q4 {
	public static void main(String[] args) {
		Solution solution = new Q4().new Solution();
		System.out.println(solution.appealSum("abbca"));
	}
	class Solution {
		public long appealSum(String s) {
			long res = 0;
			int len = s.length();
			int[] dp = new int[len];
			dp[0] = 1;
			int[] maxIndex = new int[len];
			Arrays.fill(maxIndex, -1);
			maxIndex[s.charAt(0) - 'a'] = 0;

			for (int i = 1; i < len; i++) {
				int index = s.charAt(i) - 'a';
				dp[i] = dp[i - 1] + i - maxIndex[index];
				maxIndex[index] = i;
			}
			for (int i : dp) {
				res += i;
			}
			return res;
			//超时
/*			int m = s.length() + 1, n = s.length();
			int[] grid = new int[n];
			int sum = 0;

			char[] array = s.toCharArray();
			for (int i = 0; i < n; i++) {
				grid[i] = 1;
				sum += grid[i];
			}
			for (int i = 2; i < m; i++) {
				for (int j = 0; j <= n - i; j++) {
					if (s.substring(j, i + j - 1).contains(String.valueOf(array[i + j - 1]))) {
						grid[j] = grid[j];
					} else {
						grid[j] = grid[j] + 1;
					}
					sum += grid[j];
				}
			}
			return sum;*/
		}
	}
}
