package editor.cn.WeeklyRace326;

import java.util.Arrays;

public class Q4 {
	public static void main(String[] args) {
		Solution solution = new Q4().new Solution();
		System.out.println(Arrays.toString(solution.closestPrimes(1, 6000)));
	}

	class Solution {
		public int[] closestPrimes(int left, int right) {
			int[] rse = {-1, -1};
			int min = Integer.MAX_VALUE;
			while(left < right && !isPrime(left)) left++;
			int temp = left;
			while (left < right) {
				left += 2;
				if (left < right && isPrime(left)) {
					if (left - temp < min) {
						min = left - temp;
						rse[0] = temp;
						rse[1] = left;
					}
					temp = left;
				}
			}
			return rse;
		}
		public static boolean isPrime(int n) {
			if (n <= 3) {
				return n > 1;
			}
			if (n % 6 != 1 && n % 6 != 5) {
				return false;
			}
			int sqrt = (int) Math.sqrt(n);
			for (int i = 5; i <= sqrt; i += 6) {
				if (n % i == 0 || n % (i + 2) == 0) {
					return false;
				}
			}
			return true;
		}
	}
}
