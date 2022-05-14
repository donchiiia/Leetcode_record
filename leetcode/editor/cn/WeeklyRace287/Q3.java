package WeeklyRace287;

import java.util.Arrays;

public class Q3 {
	public static void main(String[] args) {
		Solution test = new Q3().new Solution();
		System.out.println(test.maximumCandies(new int[]{4,7,5},4));
	}
	class Solution {
		public int maximumCandies(int[] candies, long k) {
			Arrays.sort(candies);
			long sum = 0;
			for (int i = 0; i < candies.length; i++) {
				sum += candies[i];
			}
			long avg = sum / k;
			int i = 0;
			for (int j = candies.length; i < j; ) {
				int mid = i + (j - i) / 2;
				if (candies[mid] < avg) i = mid + 1;
				else j = mid;
			}
			int count = 1, tag = -1;
			for (int n = i; n >=0; n--) {
				for (int m = n + 1; m < candies.length; m++) {
					count += candies[m] / candies[n];
				}
				if (count >= k){ tag = n; break;}
				count = 1;
			}
			return tag == -1? 0:candies[tag];
		}
	}
}
