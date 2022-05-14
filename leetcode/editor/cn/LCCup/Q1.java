package LCCup;

import java.lang.reflect.Array;
import java.net.Socket;
import java.util.Arrays;

public class Q1 {
	public static void main(String[] args) {
		Solution solution = new Q1().new Solution();
		System.out.println(solution.giveGem(new int[]{100, 0, 50, 100}, new int[][]{
				{0, 2},
				{0, 1},
				{3, 0},
				{3, 0}
		}));
	}
	class Solution {
		public int giveGem(int[] gem, int[][] operations) {
			int half = 0;
			for (int i = 0; i < operations.length; i++) {
				half = (gem[operations[i][0]]) >> 1;
				gem[operations[i][0]] -= half;
				gem[operations[i][1]] += half;
			}
			int[] ints = new int[gem.length];
			ints = gem.clone();
			Arrays.sort(ints);
			return ints[ints.length - 1] - ints[0];
		}
	}
}
