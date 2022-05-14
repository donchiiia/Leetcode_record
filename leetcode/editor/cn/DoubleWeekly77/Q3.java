package DoubleWeekly77;

public class Q3 {
	public static void main(String[] args) {
		Solution solution = new Q3().new Solution();
		System.out.println(solution.countUnguarded(1, 2, new int[][]{
				{0, 0},
		}, new int[][]{
				{0, 1},
		}));
	}
	class Solution {
		public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
			int[][] grid = new int[m][n];
			int w = m * n, sum = 0;

			for (int[] wall : walls) {
				grid[wall[0]][wall[1]] = w;
			}
			for (int[] guard : guards) {
				grid[guard[0]][guard[1]] = w;
			}
			for (int[] guard : guards) {
				int x = guard[0], y = guard[1];
				for (int i = x - 1; i >= 0; i--) {
					if (grid[i][y] != w) grid[i][y] -= 1;
					else break;
				}
				for (int i = x + 1; i < grid.length; i++) {
					if (grid[i][y] != w) grid[i][y] -= 1;
					else break;
				}
				for (int i = y - 1; i >= 0; i--) {
					if (grid[x][i] != w) grid[x][i] -= 1;
					else break;
				}
				for (int i = y + 1; i < grid[x].length; i++) {
					if (grid[x][i] != w) grid[x][i] -= 1;
					else break;
				}
			}
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] >= 0) sum++;
				}
			}
			return sum - guards.length - walls.length;
		}
	}
}
