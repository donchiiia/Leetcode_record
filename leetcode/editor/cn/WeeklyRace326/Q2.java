package editor.cn.WeeklyRace326;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.HashMap;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
		System.out.println(solution.distinctPrimeFactors(new int[]{2,4,3,7,10,6}));
	}
	class Solution{
		public int distinctPrimeFactors(int[] nums) {
			HashMap map = new HashMap<Integer, Integer>();
			long num = 1;
			int max = 0;
			for (int i : nums) {
				num *= i;
				for (int j = 2; j <= num; j++) {
					while (num % j == 0) {
						map.put(j, 1);
						num /= j;
					}
				}
				max = Math.max(i, max);
			}
			return map.size();
		}

	}
}
