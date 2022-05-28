package WeeklyRace293;

import java.util.Arrays;

public class Q3 {
	public static void main(String[] args) {
		Solution solution = new Q3().new Solution();
		System.out.println(solution.largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
	}
	class Solution{
		public int largestCombination(int[] candidates) {
			int ans = 0;
			for (int i = 0; i <= 30; i++) {
				int t = 0;
				for (int candidate : candidates) {
					if ((candidate >>> i & 1) != 0) t++;
				}
				ans = Math.max(ans, t);
			}
			return ans;
		}

	}
}
