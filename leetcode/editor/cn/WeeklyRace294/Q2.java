package WeeklyRace294;

import java.util.Arrays;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
		System.out.println(solution.maximumBags(new int[]{10, 2, 2}, new int[]{2, 2, 0}, 100));
	}
	class Solution{
		public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
			int[] need = new int[capacity.length];
			int res = 0;
			for (int i = 0; i < capacity.length; i++) {
				need[i] = rocks[i] - capacity[i];
			}
			Arrays.sort(need);
			int nozero = 0, maxusetag = 0;
			for (int i = need.length - 1; i >= 0; i--) {
				if (need[i] != 0) {
					nozero = i;
					break;
				}
			}
			while (nozero >= 0 && additionalRocks + need[nozero] >= 0) {
				additionalRocks += need[nozero];
				need[nozero--] = 0;
			}
			nozero++;
			return need.length - nozero;
		}
	}
}
