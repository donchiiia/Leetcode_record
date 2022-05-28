package WeeklyRace293;

import java.time.Year;
import java.util.Arrays;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
		System.out.println(solution.maxConsecutive(2, 9, new int[]{4, 6}));
	}
	class Solution{
		public int maxConsecutive(int bottom, int top, int[] special) {
			int max = 1;
			int[] temp = new int[special.length + 2];
			temp[0] = bottom - 1;
			temp[1] = top + 1;
			for (int i = 0; i < special.length; i++) {
				temp[2 + i] = special[i];
			}
			Arrays.sort(temp);
			for (int i = temp.length - 1; i > 0; i--) {
				max = Math.max(max, temp[i] - temp[i - 1]);
			}
			return max == 1 ? 0 : max - 1;
		}
	}
}

