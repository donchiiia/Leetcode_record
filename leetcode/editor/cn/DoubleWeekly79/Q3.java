package DoubleWeekly79;

import java.util.Arrays;
import java.util.jar.JarEntry;

public class Q3 {
	public static void main(String[] args) {
		Solution solution = new Q3().new Solution();
		System.out.println(solution.maximumImportance(5, new int[][]{
				{0, 1}
		}));
	}
	class Solution {
		public long maximumImportance(int n, int[][] roads) {
			int[][] rec = new int[n][2];
			for (int i = 0; i < roads.length; i++) {
				for (int j = 0; j < roads[i].length; j++) {
					rec[roads[i][j]][1]++;
				}
			}
			for (int i = 0; i < n; i++) {
				rec[i][0] = i;
			}
			long sum = 0;
			Arrays.sort(rec, (a, b) -> a[1] - b[1]);
			for (int i = 0; i < rec.length; i++) {
				rec[i][1] = i + 1;
			}
			Arrays.sort(rec, (a, b) -> a[0] - b[0]);
			for (int i = 0; i < roads.length; i++) {
				for (int j = 0; j < roads[i].length; j++) {
					sum += rec[roads[i][j]][1];
				}
			}
			return sum;
		}
	}
}
