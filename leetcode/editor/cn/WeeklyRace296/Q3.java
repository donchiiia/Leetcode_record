package WeeklyRace296;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Q3 {
	public static void main(String[] args) {
		Solution solution = new Q3().new Solution();
		System.out.println(Arrays.toString(solution.arrayChange(new int[]{1, 2, 4, 6}, new int[][]{
				{1, 3},
				{4, 7},
				{6, 1}
		})));
	}
	class Solution {
		public int[] arrayChange(int[] nums, int[][] operations) {
			int[] map1 = new int[100005];
			int[] map2 = new int[100005];
			for (int[] operation : operations) {
				if (map2[operation[0]] == 0) {
					map1[operation[0]] = operation[1];
					map2[operation[1]] = operation[0];
				} else {
					map1[map2[operation[0]]] = operation[1];
					map2[operation[1]] = map2[operation[0]];
				}
			}
			for (int i = 0; i < nums.length; i++) {
				nums[i] = map1[nums[i]] == 0 ? nums[i] : map1[nums[i]];
			}
			return nums;
		}
	}
}
