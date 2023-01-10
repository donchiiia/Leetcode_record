package editor.cn.WeeklyRace323;

import java.util.Arrays;

public class Q1 {
	public static void main(String[] args) {
		Solution solution = new Q1().new Solution();
		System.out.println(solution.deleteGreatestValue(new int[][]{{1, 2, 4}, {3, 3, 1}}));
	}
	class Solution{
		public int deleteGreatestValue(int[][] grid) {
			int res = 0;
			for (int[] ints : grid) {
				Arrays.sort(ints);
			}
			for (int length = grid[0].length - 1; length >= 0; length--) {
				int temp = 0;
				for (int i = 0; i < grid.length; i++) {
					temp = Math.max(temp, grid[i][length]);
				}
				res += temp;
			}
			return res;
		}
	}
}
